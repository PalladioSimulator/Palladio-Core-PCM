<%@ Page language="c#" Codebehind="UploadForm.aspx.cs" AutoEventWireup="false" Inherits="WebAudioStore.UploadForm" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>UploadForm</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="UploadForm" method="post" runat="server" action="http://localhost/WebAudioStore/uploaded.htm"
			autocomplete="on" language="C#">
			<INPUT id="myFile" style="Z-INDEX: 101; LEFT: 136px; WIDTH: 360px; POSITION: absolute; TOP: 96px; HEIGHT: 24px"
				type="file" size="40" runat="server">
			<DIV style="DISPLAY: inline; Z-INDEX: 102; LEFT: 40px; WIDTH: 80px; FONT-FAMILY: Arial; POSITION: absolute; TOP: 96px; HEIGHT: 24px"
				align="center" ms_positioning="FlowLayout">Audio File:</DIV>
			<asp:DataGrid id="grid" style="Z-INDEX: 103; LEFT: 88px; POSITION: absolute; TOP: 240px" runat="server"
				Width="360px" Height="312px"></asp:DataGrid>
			<asp:Button id="Button1" style="Z-INDEX: 104; LEFT: 232px; POSITION: absolute; TOP: 160px" runat="server"
				Width="96px" Height="32px" Text="Button"></asp:Button>
		</form>
	</body>
</HTML>
