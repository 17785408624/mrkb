/***
 * 自定义提示弹框的显示与隐藏
 * @param {Object} popInfo 弹框信息
 */
function popShowAndHidden(popMsg) {
	// 创建遮挡层
	var popBarrier = document.createElement('div');
	popBarrier.className = 'pop-barrier';
	document.body.appendChild(popBarrier);

	// 创建弹框边框
	var popBox = document.createElement('div');
	popBox.className = 'pop-box';
	popBarrier.appendChild(popBox);

	// 弹框标题
	var popTitle = document.createElement('div');
	popTitle.className = 'pop-title';
	popTitle.innerHTML = popMsg.title;
	popBox.appendChild(popTitle);

	// 弹框内容
	var popContent = document.createElement('div');
	popContent.className = 'pop-content';
	popContent.innerHTML = popMsg.content;
	popBox.appendChild(popContent);

	// 底部按钮
	var popFooter = document.createElement('div');
	popFooter.className = 'pop-footer';
	popBox.appendChild(popFooter);

	// 底部按钮
	var popBtn = document.createElement('span');
	popBtn.innerText = '确定';
	popFooter.appendChild(popBtn);
	popBtn.onclick = function() {
		popBarrier.remove();
	};
	
	// 弹框高度
	var popHeight = popBox.offsetHeight;
	
	// 获取屏幕高度
	var winHeight = window.innerHeight;
	popBox.style = popBox.style.cssText + 'top:calc(50% - '+ popHeight/2 +'px);';
	
}