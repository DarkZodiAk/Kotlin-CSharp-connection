using System;
using System.Windows.Forms;


namespace NotificationReceiver
{
    internal class Program
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            NotificationForm form = new NotificationForm();

            Application.Run(form);
        }
    }
}
