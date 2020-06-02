//liuyang
// Node object

function Node(id, pid, name, url, title, target, icon, iconOpen, open) {

	this.id = id;

	this.pid = pid;

	this.name = name;

	this.url = url;

	this.title = title;

	this.target = target;

	this.icon = icon;

	this.iconOpen = iconOpen;

	this._io = open || false;

	this._is = false;

	this._ls = false;

	this._hc = false;

	this._ai = 0;

	this._p;

};



// Tree object

function dTree(objName) {

	this.config = {

		target					: null,

		folderLinks			: true,

		useSelection		: true,

		useCookies			: true,

		useLines				: true,

		useIcons				: true,

		useStatusText		: false,

		closeSameLevel	: false,

		inOrder					: false

	}

	this.icon = {

		root				: '../images/tree/base.gif',

		folder			: '../images/tree/folder.gif',

		folderOpen	: '../images/tree/folderopen.gif',

		node				: '../images/tree/page.gif',

		empty				: '../images/tree/empty.gif',

		line				: '../images/tree/line.gif',

		join				: '../images/tree/join.gif',

		joinBottom	: '../images/tree/joinbottom.gif',

		plus				: '../images/tree/plus.gif',

		plusBottom	: '../images/tree/plusbottom.gif',

		minus				: '../images/tree/minus.gif',

		minusBottom	: '../images/tree/minusbottom.gif',

		nlPlus			: '../images/tree/nolines_plus.gif',

		nlMinus			: '../images/tree/nolines_minus.gif'

	};

	this.obj = objName;

	this.aNodes = [];

	this.aIndent = [];

	this.root = new Node(-1);

	this.selectedNode = null;

	this.selectedFound = false;

	this.completed = false;

};



// Adds a new node to the node array

dTree.prototype.add = function(id, pid, name, url, title, target, icon, iconOpen, open) {

	this.aNodes[this.aNodes.length] = new Node(id, pid, name, url, title, target, icon, iconOpen, open);

};



// Open/close all nodes

dTree.prototype.openAll = function() {

	this.oAll(true);

};

dTree.prototype.closeAll = function() {

	this.oAll(false);

};



// Outputs the tree to the page

dTree.prototype.toString = function() {

	var str = '<div class="dtree">\n';

	if (document.getElementById) {

		if (this.config.useCookies) this.selectedNode = this.getSelected();

		str += this.addNode(this.root);

	} else str += 'Browser not supported.';

	str += '</div>';

	if (!this.selectedFound) this.selectedNode = null;

	this.completed = true;

	return str;

};



// Creates the tree structure

dTree.prototype.addNode = function(pNode) {

	var str = '';

	var n=0;

	if (this.config.inOrder) n = pNode._ai;

	for (n; n<this.anodes.length; n++)="" {="" if="" (this.anodes[n].pid="=" pnode.id)="" var="" cn="this.aNodes[n];" cn._p="pNode;" cn._ai="n;" this.setcs(cn);="" (!cn.target="" &&="" this.config.target)="" cn.target="this.config.target;" (cn._hc="" !cn._io="" this.config.usecookies)="" cn._io="this.isOpen(cn.id);" (!this.config.folderlinks="" cn._hc)="" cn.url="null;" (this.config.useselection="" cn.id="=" this.selectednode="" !this.selectedfound)="" cn._is="true;" this.selectedfound="true;" }="" str="" +="this.node(cn," n);="" (cn._ls)="" break;="" return="" str;="" };="" creates="" the="" node="" icon,="" url="" and="" text="" dtree.prototype.node="function(node," nodeid)="" this.indent(node,="" nodeid);="" (this.config.useicons)="" (!node.icon)="" node.icon="(this.root.id" =="node.pid)" ?="" this.icon.root="" :="" ((node._hc)="" this.icon.folder="" this.icon.node);="" (!node.iconopen)="" node.iconopen="(node._hc)" this.icon.folderopen="" this.icon.node;="" (this.root.id="=" node.pid)="" this.obj="" nodeid="" '"="" src="' + ((node._io) ? node.iconOpen : node.icon) + '" alt="">';

	}

	if (node.url) {

		str += '<a id="s' + this.obj + nodeId + '" class="' + ((this.config.useSelection) ? ((node._is ? 'nodeSel' : 'node')) : 'node') + '" href="' + node.url + '" ';="" if="" (node.title)="" str="" +=" title=" "="" node.title="" '"';="" (node.target)="" node.target="" (this.config.usestatustext)="" '="" node.name="" '\';return="" true;"="" onmouseout="window.status=\'\';return true;" (this.config.useselection="" &&="" ((node._hc="" this.config.folderlinks)="" ||="" !node._hc))="" this.obj="" '.s('="" nodeid="" ');"';="" ;="" }="" else="" ((!this.config.folderlinks="" !node.url)="" node._hc="" node.pid="" !="this.root.id)" '.o('="" ');"="">';

	str += node.name;

	if (node.url || ((!this.config.folderLinks || !node.url) && node._hc)) str += '</a>';

	str += '';

	if (node._hc) {

		str += '<div id="d' + this.obj + nodeId + '" class="clip" style="display:' + ((this.root.id == node.pid || node._io) ? 'block' : 'none') + ';">';

		str += this.addNode(node);

		str += '</div>';

	}

	this.aIndent.pop();

	return str;

};



// Adds the empty and line icons

dTree.prototype.indent = function(node, nodeId) {

	var str = '';

	if (this.root.id != node.pid) {

		for (var n=0; n<this.aindent.length; 1="" n++)="" str="" +="<img src=" "="" (="" (this.aindent[n]="=" &&="" this.config.uselines)="" ?="" this.icon.line="" :="" this.icon.empty="" )="" '"="" alt="">';

		(node._ls) ? this.aIndent.push(0) : this.aIndent.push(1);

		if (node._hc) {

			str += '<a href="javascript: ' + this.obj + '.o(' + nodeId + ');" target="_blank" rel="noopener"><img id="j' + this.obj + nodeId + '" src="/codeDemos/myWeb_demo/WEB20/web/js/dtree.j/';

			if (!this.config.useLines) str += (node._io) ? this.icon.nlMinus : this.icon.nlPlus;

			else str += ( (node._io) ? ((node._ls && this.config.useLines) ? this.icon.minusBottom : this.icon.minus) : ((node._ls && this.config.useLines) ? this.icon.plusBottom : this.icon.plus ) );

			str += '" alt=""></a>';

		} else str += '<img src="/codeDemos/myWeb_demo/WEB20/web/js/dtree.j/' + ( (this.config.useLines) ? ((node._ls) ? this.icon.joinBottom : this.icon.join ) : this.icon.empty) + '" alt="">';

	}

	return str;

};



// Checks if a node has any children and if it is the last sibling

dTree.prototype.setCS = function(node) {

	var lastId;

	for (var n=0; n</this.aindent.length;></this.anodes.length;>