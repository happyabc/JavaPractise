# TextArea相关
- textarea非空判断
```
var chuangxin=document.getElementById('chuangxin').value;
        if(chuangxin.length===0) {
            alert("Textarea为空！");
            document.getElementById('chuangxin').focus();
            return false;
        }
```
- textarea获取焦点
```
document.getElementById('chuangxin').focus();
```
