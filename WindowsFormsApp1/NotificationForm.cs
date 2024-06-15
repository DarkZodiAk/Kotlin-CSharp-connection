using Microsoft.Toolkit.Uwp.Notifications;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.Net.Sockets;

namespace NotificationReceiver
{
    public partial class NotificationForm : Form
    {
        public NotificationForm()
        {
            InitializeComponent();
            ListenForMessages();
        }

        private void SendNotification(string Message)
        {
            Task.Run(delegate
            {
                new ToastContentBuilder().AddText(Message).Show();
            });
        }

        private void ListenForMessages()
        {
            Task.Run(delegate
            {
                const string ip = "127.0.0.1";
                const int port = 8080;
                var tcpEndPoint = new IPEndPoint(IPAddress.Parse(ip), port);
                var tcpSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                tcpSocket.Bind(tcpEndPoint);
                tcpSocket.Listen(1);
                while (true)
                {
                    var listener = tcpSocket.Accept();
                    var buffer = new byte[256];
                    var size = 0;
                    while (true)
                    {
                        var data = new StringBuilder();
                        do
                        {
                            size = listener.Receive(buffer);
                            data.Append(Encoding.UTF8.GetString(buffer, 0, size));
                        }
                        while (listener.Available > 0);

                        if(data.ToString() == "exit")
                        {
                            Application.Exit();
                        }

                        SendNotification(data.ToString());
                    }
                }
            });
        }
    }
}
