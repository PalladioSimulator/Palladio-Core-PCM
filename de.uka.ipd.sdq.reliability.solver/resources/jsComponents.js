/* -*- javascript -*- 
     Copyright 2006 Dr. Detlef Groth, Schwielowsee, Germany.
     License: http://creativecommons.org/licenses/LGPL/2.1/
     System        : JSCOMPONENTS_INIT_JS : 
     Created By    : Dr. Detlef Groth, Schwielowsee, Germany
     Last Modified : <061121.0606>
     ID            : $Id: jsComponents.js,v 1.45 2006/05/11 10:57:43 dgroth Exp $
     Source        : $Source: /cygdrive/d/cvs/jsComponents/css-js/jsComponents.js,v $
     $Log: jsComponents.js,v $
     Description	
     Notes
*/

/*
	Modified by Daniel Patejdl, 7th, 11th, 21st and 28th of November, and a few times
	in December 2011. I removed code that I don't need. I also removed use of the up.gif
	and down.gif images. Instead, I use normal text to indicate whether we're sorting
	ascendingly or descendingly. I added some code which does exactly that.
*/



var tables = new Array();	// will later on, for each table, store its column names

function TableEntity(table_Name, table_Column_Names) {
	this.tableName = table_Name;
	this.tableColumnNames = table_Column_Names;
}
TableEntity.prototype.getTableName = function() {
	return this.tableName;
}
TableEntity.prototype.getColumnNames = function() {
	return this.tableColumnNames;
}

Object.prototype.clone = function() {
  var newObj = (this instanceof Array) ? [] : {};
  for (i in this) {
    if (i == 'clone') continue;
    if (this[i] && typeof this[i] == "object") {
      newObj[i] = this[i].clone();
    } else newObj[i] = this[i];
  } return newObj;
};



// Simon Willison's Weblog http://simon.incutio.com/archive/2004/05/26/addLoadEvent
function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = func;
  } else {
    window.onload = function() {
      if (oldonload) {
        oldonload();
      }
      func();
    }
  }
}

/* Event Utilities */
function evtGetTarget(evt) {
    var elem;
    if (evt.target) {
        elem = (evt.target.nodeType == 3) ? evt.target.parentNode : evt.target;
    } else {
        elem = evt.srcElement;
    }
    return elem;
}

/* 
  more efficient to construct the functions ones 
  Thanks to Dean Edwards http://dean.edwards.name/
  */
var evtAdd;
if (document.addEventListener) {
    evtAdd = function(element, type, handler) {
        element.addEventListener(type, handler, null);
    };
} else if (document.attachEvent) {
    evtAdd = function(element, type, handler) {
        element.attachEvent("on" + type, handler);
    };
} else {
    alert("Your browser is not supported!");
}

/* XMLHttpRequestLoader - Class */
function XMLHttpRequestLoader() {
    var xmlhttp = false;
    if (typeof(XMLHttpRequest) != "undefined") {
        xmlhttp = new XMLHttpRequest();
    } else {
        // IE 5, 6
        try {
            xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (ev0) {
            try {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (ev1) {
                xmlhttp = false;
            }
        }
    }

    function loadXML(url, cb) {
        if (typeof(XMLHttpRequest) != "undefined") {
            load(url, cb);
        } else if (xmlhttp) {
            loadIE(url,cb);
        } else {
            alert("Browser not supported or JavaScript or ActiveX (IE) is not enabled!");
        }
    }

    function load(srcUrl, cb) {
        var req = new XMLHttpRequest();
        req.overrideMimeType('text/xml');
        req.open("GET", srcUrl, true);

        req.onreadystatechange = function() {
            if (req.readyState == 4) {
                if (cb) {
                    cb(req.responseXML);
                }
            }
        };
        req.setRequestHeader('Content-Type', 'text/xml');
        req.setRequestHeader('Cache-Control', 'no-cache');
        req.send(null);
    }

    function loadIE(srcUrl, cb) {
        xmlhttp.open("GET", srcUrl);
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4) {
                if (cb) {
                    var xmlObj = xmlhttp.responseXML;

                    if(!xmlObj.hasChildNodes) {
                        // seems that Mime-Type was not recognized
                        // we create the right object by hand
                        xmlObj = new ActiveXObject("Msxml2.DOMDocument");
                        var xmlText = xmlhttp.responseText;
                        xmlText = xmlText.replace(/<\/html>/,"");
                        xmlText = xmlText.slice(xmlText.indexOf("<body>"));
                        xmlObj.loadXML(xmlText);
                        cb(xmlObj);
                    } else {
                        cb(xmlhttp.responseXML);
                    }
                }
            }
        };
        xmlhttp.setRequestHeader('Content-Type', 'text/xml'); 
        xmlhttp.setRequestHeader('Cache-Control', 'no-cache'); 
        xmlhttp.send(null);
    }
    this.loadXML = loadXML;
}

function jsComponent(node) {
    try {
        eval("mfunc = "+node.className+";");
        mfunc(node);
    } catch (ev) {}
}

window.onload = function() {
    var divs = document.getElementsByTagName("DIV");
    var l = divs.length;
    var head = document.getElementsByTagName("head");
/*
	var images = new Array("up.gif","down.gif");
    for (var i = 0 ; i < images.length ; i++) {
        var img = new Image(); img.src = ""+images[i] ;
    }
*/
    for (var i = 0 ; i < l ; i++) {
        if (divs.item(i).className && divs.item(i).className.match(/JS.+/)) {
            var comp = new jsComponent(divs.item(i));
        }
    }
};

/* -*- javascript -*- 
     Copyright 2006 Dr. Detlef Groth, Schwielowsee, Germany.
     License: http://creativecommons.org/licenses/LGPL/2.1/
     System        : SORT-TABLE_JS : 
     Object Name   : $RCS_FILE$
     Revision      : $REVISION$
     Date          : Fri Oct 27 09:51:48 2006
     Created By    : Dr. Detlef Groth, RZPD Berlin
     Created       : Fri Oct 27 09:51:48 2006

     Last Modified : <061118.1042>
     ID            : $Id$
     Source        : $Source$
     Description	
     Notes
     */
function JSTableStripe(div) {
    var table = div.getElementsByTagName("table")[0];
    var types = new Array("even", "odd");
    var trs = table.getElementsByTagName("tr") ;
    for (var i = 0 ; i < trs.length ;i++) {
        var mod = i % 2 ;
        trs.item(i).className = types[mod];
    }
}

function JSTableSort(div) {
    var table = div.getElementsByTagName('table')[0];
    var types = new Array();
    var headers = table.getElementsByTagName('th');
    var order = "asc";
    var lastI = 100;
    for (var i = 0; i < headers.length; i++) {
        types[i] = headers.item(i).className;
    }
    for (var i = 0; i < headers.length;i++) {
        if (headers.item(i).className == "SortNumber") {
            headers[i].onclick = build_sorter(table,i,"n");
        } else if (headers.item(i).className == "SortString") {
            headers[i].onclick = build_sorter(table,i,"s");
        }
    }

    // save table column names in array...
    var tableName = div.getElementsByTagName('b')[0].innerHTML;
    var headersCopy = table.getElementsByTagName('th');//.clone();
	// and save the table names as well as their column names in a list
	var cols = new Array();	// column names of the currently considered table
	for (var i = 0; i < headersCopy.length; i++) {
	    cols.push(headersCopy.item(i).innerHTML);
	}
	tables.push(new TableEntity(tableName, cols));	// add the currently considered table to our list

    function sort_table (table,extract_fct,sort_fct) {
        var clones = new Array();
        var tbody = table.getElementsByTagName('tbody')[0];
        var rows = tbody.getElementsByTagName('tr');
        var l = rows.length;
        for (var i = 0; i < l;i++) {
            var r = rows[i];
            var v = extract_fct(r);
            clones[i] = {
                value : v,
                element : r
            };
        }
        if (sort_fct) {
            clones.sort(sort_fct);
        } else {
            clones.sort();
        }
        if (order == "asc") {
            clones.reverse();
        }
        while(tbody.firstChild) {
            tbody.removeChild(tbody.firstChild);
        }
        for (var i = 0; i < l; i++) {
            tbody.appendChild(clones[i].element);
        }
        if (rows.item(0).className == "even" || rows.item(0).className == "odd") {
            JSTableStripe(table.parentNode);
        }
    }

    function compare_numbers(a, b) {
        return (a.value-b.value);
    }

    function compare_strings(a, b) {
        a = a.value ; b = b.value;
        if (""+a<""+b) return (-1);
        if (""+a>""+b) return (1);
        if (""+a==""+b) return (0);
    }

    function extract_string_ci(r, i) {
        var text = r.getElementsByTagName('td')[i].innerHTML.toLowerCase();
        text = text.replace(/<.+?>/g,"");
        return String(text);
    }

    function extract_string_c(r, i) {
        var text = r.getElementsByTagName('td')[i].innerHTML;
        text = text.replace(/<.+?>/g,"");
        return String(text);
    }

    function extract_number(r, i) {
        var n = r.getElementsByTagName('td')[i].innerHTML;
        return parseFloat(n);
        
    }

    function build_sorter(table, i, type) {	// table, i: table header index, type: "s" or "n" ("s" for "sort strings", "n" for "sort numbers")
        return function() {
            var ths = table.getElementsByTagName("th");
            for (var j = 0; j < ths.length; j++) {
                table.getElementsByTagName("th").item(j).className = types[j];
            }
			// First, we reset all header names to their original names, i.e., to their names
            // excluding the "(Ascending)" and "(Descending)" strings. Then, we alter header i's
            // name to indicate whether we're sorting ascendingly or descendinngly.
			for (var j = 0; j < tables.length; j++) {
				if (tables[j].getTableName() == table.parentNode.getElementsByTagName("b")[0].innerHTML) {	// look for correct table
					for (var k = 0; k < ths.length; k++) {
						ths.item(k).innerHTML = tables[j].getColumnNames()[k];	// reset header names to original state
					}
				}
			}
            if (order == 'desc' && lastI == 1) {
                order = "asc";
                table.getElementsByTagName('th').item(i).className="SortAsc";
                // Now, we alter header i's name to indicate whether we're sorting ascendingly or descendingly.
                // In this case, we sort descendingly:
				table.getElementsByTagName('th').item(i).innerHTML = table.getElementsByTagName('th').item(i).innerHTML + "<br /><i>(Descending)</i>";
            } else {
                table.getElementsByTagName('th').item(i).className="SortDesc";
				table.getElementsByTagName('th').item(i).innerHTML = table.getElementsByTagName('th').item(i).innerHTML + "<br /><i>(Ascending)</i>";
                order = "desc";
            }
            lastI = 1;
            if(type == 'n') {
                sort_table(
                           table,function(r) {
                               return extract_number(r,i);
                           },
                           compare_numbers
                           );
            } else if (type == 's') {
                sort_table(
                           table, function (r) {
                               return extract_string_ci(r,i);
                           },
                           compare_strings
                           );
            }
        }
    }
}
