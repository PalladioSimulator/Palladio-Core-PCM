<%@ Page language="c#" Inherits="WebAudioStore.UploadForm" CodeFile="UploadForm.aspx.cs" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>UploadForm</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body>
		<form id="attachme" method="post" encType="multipart/form-data" runat="server">
			<INPUT id="FindFile" style="Z-INDEX: 101; LEFT: 32px; WIDTH: 496px; POSITION: absolute; TOP: 24px; HEIGHT: 22px"
				type="file" size="63" runat="server" NAME="FindFile"> &nbsp;&nbsp;
			<asp:listbox id="ListBox1" style="Z-INDEX: 102; LEFT: 32px; POSITION: absolute; TOP: 48px" runat="server"
				CssClass="txtbox" Height="100px" Width="496px" Font-Size="XX-Small"></asp:listbox>
			<asp:button id="AddFile" style="Z-INDEX: 104; LEFT: 32px; POSITION: absolute; TOP: 152px" runat="server"
				CssClass="bluebutton" Height="23px" Width="72px" Text="Add" onclick="AddFile_Click"></asp:button>
			<asp:button id="RemvFile" style="Z-INDEX: 106; LEFT: 112px; POSITION: absolute; TOP: 152px"
				runat="server" CssClass="bluebutton" Height="23px" Width="72px" Text="Remove" onclick="RemvFile_Click"></asp:button>
			<INPUT id="Upload" style="Z-INDEX: 107; LEFT: 456px; WIDTH: 71px; POSITION: absolute; TOP: 152px; HEIGHT: 24px"
				type="submit" value="Upload" runat="server" onserverclick="Upload_ServerClick" NAME="Upload">
			<asp:DataGrid id="grid" style="Z-INDEX: 103; LEFT: 48px; POSITION: absolute; TOP: 336px" runat="server"
				CellPadding="0"></asp:DataGrid>
			<HR style="Z-INDEX: 108; LEFT: 16px; WIDTH: 70.32%; POSITION: absolute; TOP: 232px; HEIGHT: 1px"
				width="70.32%" SIZE="1">
			<DIV style="DISPLAY: inline; Z-INDEX: 109; LEFT: 48px; WIDTH: 192px; POSITION: absolute; TOP: 304px; HEIGHT: 8px">Table AudioFileInfo:</DIV>
			<asp:label id="Label1" style="Z-INDEX: 105; LEFT: 40px; POSITION: absolute; TOP: 192px" runat="server"
				Height="25px" Width="249px"></asp:label>
			<asp:CheckBox id="CheckBox1" style="Z-INDEX: 110; LEFT: 328px; POSITION: absolute; TOP: 152px"
				runat="server" Text="Encode Files"></asp:CheckBox>
			<asp:Button id="Button1" style="Z-INDEX: 111; LEFT: 360px; POSITION: absolute; TOP: 192px" runat="server"
				Text="Save Logged Times" onclick="Button1_Click"></asp:Button>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 112; LEFT: 40px; POSITION: absolute; TOP: 256px" runat="server"
				Width="488px"></asp:TextBox>
		</form>
	</body>
</HTML>
