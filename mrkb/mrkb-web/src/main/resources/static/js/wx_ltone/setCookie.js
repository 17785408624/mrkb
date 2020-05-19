
/*
* 获取特定cookie的值
* @param    cookie键
* @return   cookie该键对应的值
* */
function getCookie(cname){
    var name=cname+'=';
    var ca=document.cookie.split(';');
    for(var i=0;i<ca.length;i++){
        var c=ca[i].trim();
        if(c.indexOf(name)==0)
            return c.substring(name.length,c.length);
    }
    return '';
}

/*
* 判断cookie键中是否有某个资源的id
* @param    cookie键
* @param    查询资源id
* @return   存在返回true，否则返回''
* */
function getCookieById(cname,id){
    var name=cname+'=';
    var ca=document.cookie.split(';');
    var cValue='';
    for(var i=0;i<ca.length;i++){
        var c=ca[i].trim();
        if(c.indexOf(name)==0)
            cValue=c.substring(name.length,c.length);
    }
    if(cValue!=''){
        var cArray=cValue.split(',');
        for(var i=0;i<cArray.length;i++){
            var c=cArray[i].trim();
            if(c.indexOf(id)==0){
                return true;
            }
        }
    }
    return '';
}


/*
* 添加某个资源id到cookie键中
* @param    cookie键名
* @param    资源id
* @param    cookie过期时间
* */
function addCookieById(cname,id,exdays){
    var cvalue=getCookie(cname);
    if(cvalue==''){
        cvalue=id;
    }else {
        var cArray=cvalue.split(',');
        var flag=0;
        for(var i=0;i<cArray.length;i++){
            var c=cArray[i].trim();
            if(c.indexOf(id)==0){
                flag=1;
                break;
            }
        }
        if(flag==0) {
            cvalue += ',' + id;
        }
    }

    var d=new Date();
    d.setTime(d.getTime()+(exdays*24*60*60*1000));
    var expires='expires='+d.toGMTString();
    document.cookie=cname+'='+cvalue+'; '+expires;
}