webpackJsonp([4],{TcTd:function(t,e){},"nW/4":function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n={name:"page",data:function(){return{loading:!1,style:{height:window.innerHeight+"px"},dialogFormVisible:!1,formLabelWidth:"120px",departmentList:[{departmentName:"计算机",departmentId:"02",children:[]},{departmentName:"音乐",departmentId:"02"}],department:{departmentId:"",departmentName:""},searchData:{departmentId:"",departmentName:""}}},methods:{addCourse:function(){this.dialogFormVisible=!0,this.department={}},commitMessage:function(){var t=this;this.loading=!0;var e=this.department;this._ajax("post","/department/management/add",function(e){console.log(e),t.loading=!1,t.dialogFormVisible=!1,t._notify("成功","success","添加成功")},{},function(e){console.log(e),t.loading=!1,t.dialogFormVisible=!1,t._notify("警告","warning","添加失败")},function(e){console.log(e),t.loading=!1,t.dialogFormVisible=!1,t._notify("错误","error","请求错误")},e)},search:function(){var t=this;if(""===this.searchData.departmentId&&""===this.searchData.departmentName)this.getDepartmentList();else{var e=this.searchData;this._ajax("post","/department/management/search",function(e){console.log(e),t.departmentList=e.charData},{},function(t){console.log(t)},function(){},e)}},examineAll:function(){this.searchData={}},getDepartmentList:function(){var t=this,e=this.pageInfo;this._ajax("get","/department/management/list",function(e){t.departmentList=e.charData,t.departmentList.sort(function(t,e){return parseInt(t.departmentId)-parseInt(e.departmentId)})},e,function(t){console.log(t)},function(){})}},mounted:function(){console.log(this.platform),this.getDepartmentList()}},i={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{style:t.style},[a("div",{staticStyle:{"margin-bottom":"25px"}},[a("i",{staticClass:"el-icon-plus"}),a("span",[t._v("添加")]),t._v(" "),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-button",{attrs:{type:"primary",plain:""},on:{click:function(e){return t.addCourse()}}},[t._v("添加")])],1)]),t._v(" "),a("div",[a("div",[a("i",{staticClass:"el-icon-search"}),a("span",[t._v("查询")]),t._v(" "),a("div",{staticClass:"searchContent",staticStyle:{"margin-top":"10px"}},[a("el-form",{attrs:{model:t.searchData,inline:""}},[a("el-form-item",{attrs:{label:"学院号:"}},[a("el-input",{model:{value:t.searchData.departmentId,callback:function(e){t.$set(t.searchData,"departmentId","string"==typeof e?e.trim():e)},expression:"searchData.departmentId"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"学院名:"}},[a("el-input",{model:{value:t.searchData.departmentName,callback:function(e){t.$set(t.searchData,"departmentName","string"==typeof e?e.trim():e)},expression:"searchData.departmentName"}})],1),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary",plain:""},on:{click:t.search}},[t._v("查询")]),t._v(" "),a("el-button",{attrs:{type:"success",plain:""},on:{click:t.examineAll}},[t._v("重置")])],1)],1)],1)]),t._v(" "),t._m(0)]),t._v(" "),a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.departmentList,height:"100%"}},[a("el-table-column",{attrs:{fixed:"",type:"expand"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.row.children,border:"",height:"100%"}},[a("el-table-column",{attrs:{fixed:"",prop:"majorId",label:"专业号"}}),t._v(" "),a("el-table-column",{attrs:{fixed:"",prop:"majorName",label:"专业名称"}})],1)]}}])}),t._v(" "),a("el-table-column",{attrs:{fixed:"",prop:"departmentId",label:"学院号"}}),t._v(" "),a("el-table-column",{attrs:{fixed:"",prop:"departmentName",label:"学院名"}})],1),t._v(" "),a("transition",{attrs:{name:"fade",mode:"out-in"}},[a("el-dialog",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],attrs:{title:"添加学院",visible:t.dialogFormVisible,"element-loading-text":"拼命加载中","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("el-form",{attrs:{model:t.department}},[a("el-form-item",{attrs:{label:"学院号","label-width":t.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"on",size:"normal"},model:{value:t.department.departmentId,callback:function(e){t.$set(t.department,"departmentId",e)},expression:"department.departmentId"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"学院名","label-width":t.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"on",size:"normal"},model:{value:t.department.departmentName,callback:function(e){t.$set(t.department,"departmentName",e)},expression:"department.departmentName"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取 消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.commitMessage()}}},[t._v("确 定")])],1)],1)],1)],1)},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",[e("div",[e("i",{staticClass:"el-icon-document"},[e("span",[this._v("学院列表")])])])])}]};var r=a("C7Lr")(n,i,!1,function(t){a("TcTd")},"data-v-49d604a1",null).exports;e.default=r}});
//# sourceMappingURL=4.db8608b5142d21b6d74e.js.map