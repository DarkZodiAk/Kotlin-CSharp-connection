using System.Drawing;
using System.Windows.Forms;

namespace NotificationReceiver
{
    partial class NotificationForm
    {

        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        private void InitializeComponent()
        {
            base.SuspendLayout();
            base.AutoScaleMode = AutoScaleMode.None;
            base.ClientSize = new Size(10, 10);
            base.ControlBox = false;
            base.FormBorderStyle = FormBorderStyle.None;
            base.Margin = new Padding(2);
            base.MaximizeBox = false;
            base.MinimizeBox = false;
            base.Name = "ServiceHubHelper";
            base.ShowIcon = false;
            base.ShowInTaskbar = false;
            this.Text = "ServiceHub.Helper";
            base.WindowState = FormWindowState.Minimized;
            base.ResumeLayout(false);
        }

        #endregion
    }
}

