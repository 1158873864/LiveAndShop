import fetch from '@/config/fetch'


//登录
export const login = data => fetch('/admin/login', data, 'POST');
export const getAdminInfo = () => fetch('/admin/info');
//退出
//export const signout = () => fetch('/admin/signout');

//获取用户列表
//export const getUsersInfo = data => fetch('/UserManage/show/showUser', data, 'POST');
//export const getUsersCount = data => fetch('', data, 'POST');



//后端提供
//1.通过ID显示用户信息UserManage /showUser/ {UserId}
export const getUserList = data => fetch('/UserManage/showUser', data, 'POST');

//2.查询全部用户信息UserManage / QueryAllUser
export const getQueryAllUser = data => fetch('/UserManage/QueryAllUser', data, 'POST');

//3.查询所有得粉丝数量和关注数量UserManage /FansAndConcernCount/{ UserId} 
export const getFansAndConcernCount = data => fetch('/UserManage/FansAndConcernCount', data, 'POST');

//4.查询所有得粉丝姓名UserManage /FindFansName/{ UserId}
export const getFindFansName = data => fetch('/UserManage/FindFansName', data, 'POST');

//5.查询所有得关注姓名UserManage/ QueryConceryName/{ UserId}
export const getQueryConceryName = data => fetch('/UserManage/QueryConceryName', data, 'POST');

//6.查询全部商品UserManage/ QuerySp
export const getQuerySp = data => fetch('/UserManage/QuerySp', data, 'POST');

//7.省市三级联动（省）
export const getQueryProvinice = data => fetch('/UserManage/QueryProvinice', data, 'POST');

//8.查找市UserManage/ QueryCity/{provinceId}
export const getQueryCity = data => fetch('/UserManage/QueryCity', data, 'POST');  

//9.查找区得联动UserManage/ QueryCounty/{cityId}
export const getQueryCounty = data => fetch('/UserManage/QueryCounty', data, 'POST');  

//10.通过点击分类查询所有得店铺UserManage/  QueryShop{Dp_propert}
 export const getQueryShop = data => fetch('/UserManage/QueryShop', data, 'POST'); 
 
//11.查找全部店铺UserManage/  QueryAllShop
export const getQueryAllShop = data => fetch('/UserManage/QueryAllShop', data, 'POST');   



//饿了么数据
//export const getUserList = data => fetch('/v1/users/list', data);
//export const getUserCount = data => fetch('/v1/users/count', data);
//export const deleteResturant = restaurant_id => fetch('/shopping/restaurant/' + restaurant_id, {}, 'DELETE');