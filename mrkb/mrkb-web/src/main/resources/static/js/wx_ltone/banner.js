/**
 * 动态加载不带点击的轮播图
 */
function bannerNoClick(elementObj,imgArr){
	var sliderDiv = document.createElement('div');
		sliderDiv.className = 'swiper-container swiper-container-horizontal';
		elementObj.appendChild(sliderDiv);
	
	// 图片层
	var sliderGroup = document.createElement('div');
		sliderGroup.className = 'swiper-wrapper';
		sliderDiv.appendChild(sliderGroup);
	
	var html = '';
	for (var i = 0; i < imgArr.length + 2; i++) {
		if (i == 0) {
			html += '<div class="swiper-slide swiper-slide-duplicate">' +
					'	<a href="javascript:void(0);">' +
					'		<img src="'+ baseImgPath + imgArr[imgArr.length - 1] + '" onerror="javascript:this.src=\'http://via.placeholder.com/216X120\'">' +
					'	</a>' +
					'</div>';
		} else if (i == imgArr.length + 1) {
			html += '<div class="swiper-slide swiper-slide-duplicate">' +
					'	<a href="javascript:void(0);">' +
					'		<img src="'+ baseImgPath + imgArr[0] +'" onerror="javascript:this.src=\'http://via.placeholder.com/216X120\'">' +
					'	</a>' +
					'</div>';
		} else {
			var k = i - 1;
			html += '<div class="swiper-slide">' +
					'	<a href="javascript:void(0);">' +
					'		<img src="'+ baseImgPath + imgArr[k] + '" onerror="javascript:this.src=\'http://via.placeholder.com/216X120\'">' +
					'	</a>' +
					'</div>';
		}
	}
	sliderGroup.innerHTML = html;
	
	// 图片下面的圆点
	var sliderIndicator = document.createElement('div');
	sliderIndicator.className = 'swiper-pagination swiper-pagination-bullets';
	sliderDiv.appendChild(sliderIndicator);
	var indicatorHTML = '';
	for (var j = 0; j < imgArr.length; j++) {
		if (j == 0) {
			indicatorHTML += '<span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span>';
		} else {
			indicatorHTML += '<span class="swiper-pagination-bullet"></span>';
		}
	}
	sliderIndicator.innerHTML = indicatorHTML;
	
	$(".swiper-container").swiper({
		loop: true,
		autoplay: 3000
	});
} 

