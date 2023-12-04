(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-fc225528"],{2648:function(e,t,a){"use strict";a("c86d")},5246:function(e,t,a){"use strict";a("68ef"),a("9d70"),a("3743"),a("8a0b")},"6b41":function(e,t,a){"use strict";var s=a("d282"),r=a("b1d2"),n=a("ad06"),i=Object(s["a"])("nav-bar"),o=i[0],c=i[1];t["a"]=o({props:{title:String,fixed:Boolean,zIndex:[Number,String],leftText:String,rightText:String,leftArrow:Boolean,placeholder:Boolean,safeAreaInsetTop:Boolean,border:{type:Boolean,default:!0}},data:function(){return{height:null}},mounted:function(){var e=this;if(this.placeholder&&this.fixed){var t=function(){e.height=e.$refs.navBar.getBoundingClientRect().height};t(),setTimeout(t,100)}},methods:{genLeft:function(){var e=this.$createElement,t=this.slots("left");return t||[this.leftArrow&&e(n["a"],{class:c("arrow"),attrs:{name:"arrow-left"}}),this.leftText&&e("span",{class:c("text")},[this.leftText])]},genRight:function(){var e=this.$createElement,t=this.slots("right");return t||(this.rightText?e("span",{class:c("text")},[this.rightText]):void 0)},genNavBar:function(){var e,t=this.$createElement;return t("div",{ref:"navBar",style:{zIndex:this.zIndex},class:[c({fixed:this.fixed,"safe-area-inset-top":this.safeAreaInsetTop}),(e={},e[r["b"]]=this.border,e)]},[t("div",{class:c("content")},[this.hasLeft()&&t("div",{class:c("left"),on:{click:this.onClickLeft}},[this.genLeft()]),t("div",{class:[c("title"),"van-ellipsis"]},[this.slots("title")||this.title]),this.hasRight()&&t("div",{class:c("right"),on:{click:this.onClickRight}},[this.genRight()])])])},hasLeft:function(){return this.leftArrow||this.leftText||this.slots("left")},hasRight:function(){return this.rightText||this.slots("right")},onClickLeft:function(e){this.$emit("click-left",e)},onClickRight:function(e){this.$emit("click-right",e)}},render:function(){var e=arguments[0];return this.placeholder&&this.fixed?e("div",{class:c("placeholder"),style:{height:this.height+"px"}},[this.genNavBar()]):this.genNavBar()}})},"8a0b":function(e,t,a){},b775:function(e,t,a){"use strict";a("e7e5");var s=a("d399"),r=(a("a481"),a("bc3a")),n=a.n(r),i=a("41cb"),o=a("4360"),c=a("5d2d"),u=n.a.create({baseURL:"/prod-api",withCredentials:!1,timeout:15e3});u.interceptors.request.use((function(e){return c["a"].getToken()&&(e.headers["Authorization"]=c["a"].getToken()),e}),(function(e){return Promise.reject(e)})),u.interceptors.response.use((function(e){console.log("response",e),e.headers.token&&o["a"].dispatch("app/toggleToken",e.headers.token);var t=e.data;return 2e4!==t.code?Promise.reject(t.msg||"error"):t}),(function(e){if(e.response)switch(e.response.status){case 401:return o["a"].dispatch("app/toggleUser",{}),o["a"].dispatch("app/toggleToken",""),i["a"].replace({path:"/login",query:{redirect:i["a"].currentRoute.path}}),Promise.reject(e.response.data.message);case 500:if(e.response.data.message)return e.response.data.message.indexOf("relogin")>-1?(o["a"].dispatch("app/toggleUser",{}),o["a"].dispatch("app/toggleToken",""),i["a"].replace({path:"/login",query:{redirect:i["a"].currentRoute.path}}),Promise.reject(e.response.data.message)):e.response.data.message.indexOf("该手机号已经绑定其他微信号")>-1?(o["a"].dispatch("app/toggleUser",{}),o["a"].dispatch("app/toggleToken",""),s["a"].fail(e.response.data.message),i["a"].replace({path:"/login",query:{redirect:i["a"].currentRoute.path}}),Promise.reject(e.response.data.message)):(s["a"].fail(e.response.data.message),Promise.reject(e.response.data.message));break;default:return Promise.reject(e.response.data.message)}})),t["a"]=u},c24f:function(e,t,a){"use strict";var s=a("b775");t["a"]={getUserInfo:function(){return Object(s["a"])({url:"/user/getInfo",method:"get"})},updateUserName:function(e){var t={userName:e};return Object(s["a"])({url:"/user/updateUserName/",method:"post",params:t})},updatePwd:function(e){return Object(s["a"])({url:"/account/updatePwd",method:"post",params:e})},updateGender:function(e){return Object(s["a"])({url:"/user/updateGender/"+e,method:"post"})},updatePassword:function(e,t,a){return Object(s["a"])({url:"/user/updatePassword/"+e+"/"+t+"/"+a,method:"post"})},upload:function(e){return Object(s["a"])({url:"/file/upload/base64",method:"post",data:e})},sendSmsCode:function(e){return Object(s["a"])({url:"/user/sendSmsCode",method:"post",params:{mobile:e}})},getWxSign:function(e){return Object(s["a"])({url:"/user/getWxSign",method:"post",params:e})},getWxOpenId:function(e){return Object(s["a"])({url:"/user/getWxOpenId",method:"post",params:e})}}},c86d:function(e,t,a){},f588:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e._self._c;e._self._setupProxy;return t("div",{staticClass:"updateUserName"},[t("van-nav-bar",{attrs:{title:"修改姓名","left-arrow":""},on:{"click-left":e.onClickLeft}}),e._v(" "),t("van-cell-group",[t("van-field",{attrs:{required:"",clearable:"",label:"用户名",placeholder:"请输入"},model:{value:e.userName,callback:function(t){e.userName=t},expression:"userName"}})],1),e._v(" "),t("van-button",{attrs:{type:"primary",round:"",block:""},on:{click:e.submit}},[e._v("确定")])],1)},r=[],n=a("bd86"),i=(a("e7e5"),a("d399")),o=(a("be7f"),a("565f")),c=(a("5246"),a("6b41")),u=(a("0653"),a("34e9")),l=(a("c194"),a("7744")),d=(a("66b9"),a("b650")),h=a("c24f"),p=a("4360"),f=a("5d2d"),g={components:Object(n["a"])(Object(n["a"])(Object(n["a"])(Object(n["a"])(Object(n["a"])(Object(n["a"])({},d["a"].name,d["a"]),l["a"].name,l["a"]),u["a"].name,u["a"]),c["a"].name,c["a"]),o["a"].name,o["a"]),i["a"].name,i["a"]),data:function(){return{userName:""}},mounted:function(){this.init()},methods:{init:function(){this.userName=f["a"].getUser().nickName},onClickLeft:function(){this.$router.go(-1)},submit:function(){var e=this;this.userName&&""!==this.userName?h["a"].updateUserName(this.userName).then((function(t){p["a"].dispatch("app/toggleUser",t.data),e.$router.go(-1)})):Object(i["a"])("请输入姓名")}}},m=g,b=(a("2648"),a("2877")),v=Object(b["a"])(m,s,r,!1,null,null,null);t["default"]=v.exports}}]);