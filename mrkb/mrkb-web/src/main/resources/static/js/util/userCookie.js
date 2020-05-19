function getCookie(name) {
	var allcookies = document.cookie;
	var arrcookie = allcookies.split(";"); //分割
	//遍历匹配
	for (var i = 0; i < arrcookie.length; i++) {
		var arr = arrcookie[i].split("=");
		if (arr[0].trim() == name) {
			return arr[1];
		}
	}
}