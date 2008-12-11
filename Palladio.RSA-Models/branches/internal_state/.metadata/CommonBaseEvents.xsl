<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <xsl:comment>Licensed Material - Property of IBM</xsl:comment>
      <xsl:comment>(C) Copyright IBM Corp. 2005, 2006 - All Rights Reserved.</xsl:comment>
      <xsl:comment>US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.</xsl:comment>
      <xsl:comment>Author:  Paul E. Slauenwhite</xsl:comment>
      <xsl:comment>Version: July 21, 2006</xsl:comment>
      <xsl:comment>Since:   April 20, 2005</xsl:comment>
      <head>
        <title>Common Base Event XML Viewer</title>
        <script language="JavaScript1.3">
          &lt;!--
          var BROWSER_NAME = navigator.appName;
          var BROWSER_VERSION = parseInt(navigator.appVersion);
          var sortColumnIndex = 0;
          var sortIncreasing = true;
          var filters = new Array();
          var filterTableRowCount = 0;
          function initialize(){
            var eventTableRows = window.document.getElementById("eventTable").rows;
            for (var counter = 0;counter &lt; eventTableRows.length;counter++){
              var cellText = parseFloat(eventTableRows[counter].cells[2].innerHTML);
              if((cellText &gt;= 0) &amp;&amp; (cellText &lt;= 70)){
                var greenAndBlue = parseInt(Math.abs(225 - (parseFloat(cellText/70.0) * 225)));
                eventTableRows[counter].cells[2].style.background = "rgb(255, " + greenAndBlue + ", " + greenAndBlue + ")"
              }
            }
            configureEventTable();
            window.document.getElementById("loadingPane").style.visibility="hidden";
          }
          function openPreferencesWindow(){
            if(((BROWSER_NAME != "Microsoft Internet Explorer") &amp;&amp; (BROWSER_NAME != "Netscape")) || (BROWSER_VERSION &lt; 4)){
              alert("The Common Base Event XML Viewer requires Netscape Navigator 4.x+ or Microsoft Internet Explorer 4.x+.");
            }
            else{
              var newWindow = window.open("","newWindow","width=600,height=500,left=" + ((screen.availWidth - 600) / 2) + ",top=" + ((screen.availHeight - 500) / 2) + ",resizable=yes,scrollbars=yes,toolbar=no,location=no,directories=no,status=no,menubar=no,copyhistory=no");
              newWindow.document.writeln("&lt;html&gt;");
              newWindow.document.writeln("  &lt;head&gt;");
              newWindow.document.writeln("    &lt;title&gt;Common Base Event XML Viewer Preferences&lt;/title&gt;");
              newWindow.document.writeln("  &lt;/head&gt;");
              newWindow.document.writeln("  &lt;body style='background:#DDDDDD;'&gt;");
              newWindow.document.writeln("    &lt;center&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;a style='font-weight:bold; font-size:140%;'&gt;Common Base Event XML Viewer Preferences&lt;/a&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;a style='font-weight:bold; font-size:120%;'&gt;Sorting Order&lt;/a&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;form&gt;");
              newWindow.document.writeln("        &lt;table cellspacing='1' cellpadding='5'&gt;");
              newWindow.document.writeln("          &lt;tr&gt;");
              newWindow.document.writeln("            &lt;td&gt;&lt;select id='sortColumn'&gt;&lt;option&gt;#&lt;/option&gt;&lt;option&gt;Time&lt;/option&gt;&lt;option&gt;Severity&lt;/option&gt;&lt;option&gt;Message&lt;/option&gt;&lt;option&gt;Situation&lt;/option&gt;&lt;option&gt;Component&lt;/option&gt;&lt;option&gt;Logger&lt;/option&gt;&lt;option&gt;Log Level&lt;/option&gt;&lt;/select&gt;&lt;/td&gt;");
              newWindow.document.writeln("            &lt;td&gt;&lt;input id='sortDirectionIncreasing' name='sortDirectionGroup' type='radio' &gt;Increasing&lt;/input&gt;&lt;br/&gt;&lt;input id='sortDirectionDecreasing' name='sortDirectionGroup' type='radio' value='down'&gt;Decreasing&lt;/input&gt;&lt;/td&gt;");
              newWindow.document.writeln("          &lt;/tr&gt;");
              newWindow.document.writeln("        &lt;/table&gt;");
              newWindow.document.writeln("      &lt;/form&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;a style='font-weight:bold; font-size:120%;'&gt;Filtering Rules&lt;/a&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;a style='font-size:75%;'&gt;(* = any string)&lt;/a&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;a style='font-size:75%; color:#0000FF; text-decoration:none;' href='#' onClick='window.opener.addFilter(window);return false;'&gt;(Add)&lt;/a&gt;");
              newWindow.document.writeln("      &lt;form&gt;");
              newWindow.document.writeln("        &lt;table id='filterTable' cellspacing='1' cellpadding='5'&gt;");
              newWindow.document.writeln("        &lt;/table&gt;");
              newWindow.document.writeln("      &lt;/form&gt;");
              newWindow.document.writeln("      &lt;br/&gt;");
              newWindow.document.writeln("      &lt;form&gt;");
              newWindow.document.writeln("        &lt;input type='button' style='width:5em;' value='Save' onClick='window.opener.savePreferences(window);window.close();return false;'/&gt;&amp;#xA0;&amp;#xA0;&lt;input type='button' style='width:5em;' value='Cancel' onClick='window.close();return false;'/&gt;");
              newWindow.document.writeln("      &lt;/form&gt;");
              newWindow.document.writeln("    &lt;/center&gt;");
              newWindow.document.writeln("  &lt;/body&gt;");
              newWindow.document.writeln("&lt;/html&gt;");
              newWindow.document.close();
              newWindow.document.getElementById("sortColumn").options[sortColumnIndex].selected = "true";
              newWindow.document.getElementById("sortDirection" + (sortIncreasing?"In":"De") + "creasing").checked = true
              filterTableRowCount = 0;
              for(var counter = 0;counter &lt; filters.length;counter++){
                addFilter(newWindow);
                newWindow.document.getElementById("filterColumn_" + counter).selectedIndex = filters[counter][0];
                newWindow.document.getElementById("filterRule_" + counter).value = filters[counter][1];
                newWindow.document.getElementById("filterRule" + (filters[counter][2]?"In":"Ex") + "clude_" + counter).checked = true;
              }
            }
          }
          function addFilter(preferenceWindow){
            var filterTable = preferenceWindow.document.getElementById("filterTable");
            var rowIndex = filterTable.rows.length;
            var newRow = filterTable.insertRow(rowIndex);
            filterTableRowCount += 1;
            newRow.insertCell(0).innerHTML = filterTableRowCount + ".&#xA0;";
            newRow.insertCell(1).innerHTML = "&lt;select id='filterColumn_" + rowIndex + "'&gt;&lt;option&gt;#&lt;/option&gt;&lt;option&gt;Time&lt;/option&gt;&lt;option&gt;Severity&lt;/option&gt;&lt;option&gt;Message&lt;/option&gt;&lt;option&gt;Situation&lt;/option&gt;&lt;option&gt;Component&lt;/option&gt;&lt;option&gt;Logger&lt;/option&gt;&lt;option&gt;Log Level&lt;/option&gt;&lt;/select&gt;";
            newRow.insertCell(2).innerHTML = "&lt;input id='filterRule_" + rowIndex + "' type='text' value='*'/&gt;";
            newRow.insertCell(3).innerHTML = "&lt;input id='filterRuleInclude_" + rowIndex + "' name='filterRuleGroup_" + rowIndex + "' type='radio' checked='true' &gt;Include&lt;/input&gt;&lt;br/&gt;&lt;input id='filterRuleExclude_" + rowIndex + "' name='filterRuleGroup_" + rowIndex + "' type='radio' value='down'&gt;Exclude&lt;/input&gt;";
            newRow.insertCell(4).innerHTML = "&lt;a style='font-size:75%; color:#0000FF; text-decoration:none;' href='#' onClick='window.opener.removeFilter(window," + rowIndex + ");return false;'&gt;(Remove)&lt;/a&gt;";
          }
          function removeFilter(preferenceWindow,selectedRowIndex){
            var filterTable = preferenceWindow.document.getElementById("filterTable");
            filterTable.rows[selectedRowIndex].style.display = "none";
            filterTableRowCount -= 1;
            var numberCount = 1;
            for(var counter = 0;counter &lt; filterTable.rows.length;counter++){
              if(filterTable.rows[counter].style.display == ""){
                filterTable.rows[counter].cells[0].innerHTML = (numberCount + ".&#xA0;");
                numberCount += 1;
              }
            }
          }
          function savePreferences(preferenceWindow){
            sortColumnIndex = preferenceWindow.document.getElementById("sortColumn").selectedIndex;
            sortIncreasing = preferenceWindow.document.getElementById("sortDirectionIncreasing").checked;
            filters = new Array();
            var filterTable = preferenceWindow.document.getElementById("filterTable");
            for(var counter = 0;counter &lt; filterTable.rows.length;counter++){
              if(filterTable.rows[counter].style.display != "none"){
                filters[filters.length] = new Array(preferenceWindow.document.getElementById("filterColumn_" + counter).selectedIndex,preferenceWindow.document.getElementById("filterRule_" + counter).value,preferenceWindow.document.getElementById("filterRuleInclude_" + counter).checked);
                var filter = "^" + filters[filters.length - 1][1].replace(/\\/g,"\\\\");
                filter = filter.replace(/\?/g,"\\?");
                filter = filter.replace(/\//g,"\\/");
                filter = filter.replace(/\./g,"\\.");
                filter = filter.replace(/\[/g,"\\[");
                filter = filter.replace(/\]/g,"\\]");
                filter = filter.replace(/\{/g,"\\{");
                filter = filter.replace(/\}/g,"\\}");
                filter = filter.replace(/\(/g,"\\(");
                filter = filter.replace(/\)/g,"\\)");
                filter = filter.replace(/\+/g,"\\+");
                filter = filter.replace(/\|/g,"\\|");
                filter = filter.replace(/\*/g,"(.|\s)+");
                filters[filters.length - 1][3] = filter + "$";
              }
            }
            configureEventTable();
          }
          function configureEventTable(){
            var eventTable = window.document.getElementById("eventTable");
            var sortableRows = new Array(eventTable.rows.length - 1);
            for(var counter = 1;counter &lt; eventTable.rows.length;counter++){
              sortableRows[counter - 1] = eventTable.rows[counter];
              sortableRows[counter - 1].style.display = "";
            }
            for (var counter = 1; counter &lt; sortableRows.length; counter++){
              var index = counter;
              var currentRow = sortableRows[counter];
              var currentCellText = parseInt(currentRow.cells[0].innerHTML.toLowerCase());
              while ((index &gt; 0) &amp;&amp; (parseInt(sortableRows[index - 1].cells[0].innerHTML.toLowerCase()) &gt; currentCellText)){
                sortableRows[index] = sortableRows[index - 1];
                index -= 1;
              }
              sortableRows[index] = currentRow;
            }
            if(sortColumnIndex != 0){
              for (var counter = 1; counter &lt; sortableRows.length; counter++){
                var index = counter;
                var currentRow = sortableRows[counter];
                var currentCellText = currentRow.cells[sortColumnIndex].innerHTML.toLowerCase();
                if (!isNaN(parseInt(currentCellText))){
                  currentCellText = parseInt(currentCellText);
                }
                while (index &gt; 0){
                  var sortedPreviousCellText = sortableRows[index - 1].cells[sortColumnIndex].innerHTML.toLowerCase();
                  if (!isNaN(parseInt(sortedPreviousCellText))){
                    sortedPreviousCellText = parseInt(sortedPreviousCellText);
                  }
                  if(sortedPreviousCellText &lt;= currentCellText){
                    break;
                  }
                  sortableRows[index] = sortableRows[index - 1];
                  index -= 1;
                }
                sortableRows[index] = currentRow;
              }
            }
            if(!sortIncreasing){
              sortableRows.reverse();
            }
            var rowCount = 0;
            for (var counter = 0;counter &lt; sortableRows.length;counter++){
              eventTable.tBodies[0].appendChild(sortableRows[counter]);
              if(filterRow(sortableRows[counter])){
                sortableRows[counter].style.display = "none";
              }
              else{
                if(rowCount % 2 == 0){
                  sortableRows[counter].style.background = "#FFFFC1";
                }
                else{
                  sortableRows[counter].style.background = "#FFFFE1";
                }
                rowCount += 1;
              }
            }
          }
          function filterRow(row){
            for(var counter = 0;counter &lt; row.cells.length;counter++){
              for(var filterCounter = 0;filterCounter &lt; filters.length;filterCounter++){
                if(filters[filterCounter][0] == counter){
              	  if(row.cells[counter].innerHTML.match(new RegExp(filters[filterCounter][3]))){
              	    if(!filters[filterCounter][2]){
              	      return true;
              	    }
              	  }
              	  else if(filters[filterCounter][2]){
              	    return true;
              	  }
                }
              }
            }
            return false;
          }
          // --&gt;
        </script>
      </head>
      <body onLoad="setTimeout('initialize()',1);return false;">
        <div id="loadingPane" style="position:absolute; font-weight:bold; font-size:140%; background-color:white; layer-background-color:white; left:0px; top:0px; height:100%; width:100%;">
        <center>
        <br/>
        <br/>
        Loading...
        </center>
        </div>
        <center>
          <br/>
          <br/>
          <noscript>
            <a style="font-weight:bold; color:#FF0000; font-size:140%;">This viewer requires JavaScript to be enabled in your brower's preferences.</a>
            <br/>
            <br/>
          </noscript>
          <a style="font-weight:bold; font-size:140%;">Common Base Event XML Viewer</a>
          <br/>
          <br/>
          <table width="90%">
            <tr align="left">
              <td><a style="font-size:75%;">|</a>&#xA0;<a style="font-size:75%; color:#0000FF; text-decoration:none;" href="#" onClick="openPreferencesWindow();return false;">Preferences</a>&#xA0;<a style="font-size:75%;">|</a>&#xA0;<a style="font-size:75%; color:#0000FF; text-decoration:none;" href="#" onClick="alert('The Common Base Event XML Viewer displays several Common Base Event properties from Common Base Event XML documents in a tabular view.  Select the column header for an explanation of the Common Base Event property in that column.  The viewer also provides column-level sorting and hierarchal filtering (see Preferences).');return false;">Help</a>&#xA0;<a style="font-size:75%;">|</a></td>
            </tr>
          </table>
          <table id="eventTable" border="1" cellspacing="1" cellpadding="5" width="90%">
            <tr style="background:#ACD6FF;">
              <th width="5%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The zero-based integer position of this Common Base Event XML fragment in the Common Base Event XML document.');return false;">#</a></th>
              <th width="15%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The XSD dateTime creationTime attribute of this Common Base Event XML fragment in the Common Base Event XML document.');return false;">Time</a></th>
              <th width="5%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The integer severity attribute (0 - 70) of this Common Base Event XML fragment in the Common Base Event XML document.  The cells in this column use a colored gradient to denote increasing severity (0 or pink to 70 or red).');return false;">Severity</a></th>
              <th width="25%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The textual message attribute of this Common Base Event XML fragment in the Common Base Event XML document.');return false;">Message</a></th>
              <th width="5%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The textual categoryName attribute of the situation element of this Common Base Event XML fragment in the Common Base Event XML document.');return false;">Situation</a></th>
              <th width="15%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The textual component attribute of the sourceComponentId element of this Common Base Event XML fragment in the Common Base Event XML document.');return false;">Component</a></th>
              <th width="15%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The textual name of the logger that logged this Common Base Event XML fragment based on the extendedDataElement with a Logger_Name or CommonBaseEventLogRecord:loggerName name attribute in this Common Base Event XML fragment in the Common Base Event XML document.');return false;">Logger</a></th>
              <th width="10%"><a style="color:#0000FF; text-decoration:none;" href="#" onClick="alert('The textual name of the logging level of the logger that logged this Common Base Event XML fragment based on the extendedDataElement with a Logging_Level or CommonBaseEventLogRecord:level name attribute in this Common Base Event XML fragment in the Common Base Event XML document.');return false;">Log Level</a></th>
            </tr>
            <xsl:for-each select="CommonBaseEvents/CommonBaseEvent">
              <tr>
                <td align="center"><xsl:value-of select="position()"/></td>
                <xsl:choose>
                  <xsl:when test="string(@creationTime)">
                    <td align="center"><xsl:value-of select="@creationTime"/></td>
                  </xsl:when>
                  <xsl:otherwise>
                    <td>&#xA0;</td>
                  </xsl:otherwise>
                </xsl:choose>
                <xsl:choose>
                  <xsl:when test="string(@severity)">
                    <td align="center"><xsl:value-of select="@severity"/></td>
                  </xsl:when>
                  <xsl:otherwise>
                    <td>&#xA0;</td>
                  </xsl:otherwise>
                </xsl:choose>
                <xsl:choose>
                  <xsl:when test="string(@msg)">
                    <td align="center"><xsl:value-of select="@msg"/></td>
                  </xsl:when>
                  <xsl:otherwise>
                    <td>&#xA0;</td>
                  </xsl:otherwise>
                </xsl:choose>
                <xsl:choose>
                  <xsl:when test="string(situation/@categoryName)">
                    <td align="center"><xsl:value-of select="substring(situation/@categoryName,0,string-length(situation/@categoryName) - 8)"/></td>
                  </xsl:when>
                  <xsl:otherwise>
                    <td>&#xA0;</td>
                  </xsl:otherwise>
                </xsl:choose>
                <xsl:choose>
                  <xsl:when test="string(sourceComponentId/@component)">
                    <td align="center"><xsl:value-of select="sourceComponentId/@component"/></td>
                  </xsl:when>
                  <xsl:otherwise>
                    <td>&#xA0;</td>
                  </xsl:otherwise>
                </xsl:choose>
                <xsl:choose>
                  <xsl:when test="string(extendedDataElements[@name='Logger_Name']/values)">
                    <td align="center"><xsl:value-of select="extendedDataElements[@name='Logger_Name']/values"/></td>
                  </xsl:when>
                  <xsl:when test="string(extendedDataElements[@name='CommonBaseEventLogRecord:loggerName']/values)">
                    <td align="center"><xsl:value-of select="extendedDataElements[@name='CommonBaseEventLogRecord:loggerName']/values"/></td>
                  </xsl:when>
                  <xsl:otherwise>
                    <td>&#xA0;</td>
                  </xsl:otherwise>
                </xsl:choose>
                <xsl:choose>
                  <xsl:when test="string(extendedDataElements[@name='Logging_Level']/values)">
                    <td align="center"><xsl:value-of select="extendedDataElements[@name='Logging_Level']/values"/></td>
                  </xsl:when>
                  <xsl:when test="string(extendedDataElements[@name='CommonBaseEventLogRecord:level']/children[@name='CommonBaseEventLogRecord:name']/values)">
                    <td align="center"><xsl:value-of select="extendedDataElements[@name='CommonBaseEventLogRecord:level']/children[@name='CommonBaseEventLogRecord:name']/values"/></td>
                  </xsl:when>
                  <xsl:otherwise>
                    <td>&#xA0;</td>
                  </xsl:otherwise>
                </xsl:choose>
              </tr>
            </xsl:for-each>
          </table>
        </center>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
