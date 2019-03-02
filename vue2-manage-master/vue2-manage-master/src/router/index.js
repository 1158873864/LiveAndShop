import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const login = r => require.ensure([], () => r(require('@/page/login/login')), 'login');
const Manage = r => require.ensure([], () => r(require('@/page/manage/Manage')), 'Manage');
const home = r => require.ensure([], () => r(require('@/page/home/home')), 'home');

//功能测试
const usersInfo = r => require.ensure([], () => r(require('@/page/test/usersInfo')), 'usersInfo');
const commodity = r => require.ensure([], () => r(require('@/page/test/commodity')), 'commodity');
const shop = r => require.ensure([], () => r(require('@/page/test/shop')), 'shop');

//店铺管理
const ShopOperate = r => require.ensure([], () => r(require('@/page/shop/ShopOperate')), 'ShopOperate');
const ShopInfo = r => require.ensure([], () => r(require('@/page/shop/ShopInfo')), 'ShopInfo');
const ShopAddress = r => require.ensure([], () => r(require('@/page/shop/ShopAddress')), 'ShopAddress');

//订单管理
const Order = r => require.ensure([], () => r(require('@/page/order-manage/Order')), 'Order');

//商品管理
const Release = r => require.ensure([], () => r(require('@/page/goods-manage/Release')), 'Release');
const InSale = r => require.ensure([], () => r(require('@/page/goods-manage/InSale')), 'InSale');
const AlreReleased = r => require.ensure([], () => r(require('@/page/goods-manage/AlreReleased')), 'AlreReleased');
const NotReleased = r => require.ensure([], () => r(require('@/page/goods-manage/NotReleased')), 'NotReleased');
const LiveGoods = r => require.ensure([], () => r(require('@/page/goods-manage/LiveGoods')), 'LiveGoods');

//客户管理
const Customer = r => require.ensure([], () => r(require('@/page/customer-manage/Customer')), 'Customer');

//直播管理
const Live = r => require.ensure([], () => r(require('@/page/live-manage/Live')), 'Live');

//运费设置
const Freight = r => require.ensure([], () => r(require('@/page/freight-set/Freight')), 'Freight');
const ExpressTplt = r => require.ensure([], () => r(require('@/page/freight-set/ExpressTplt')), 'ExpressTplt');

const routes = [
	{
		path: '/',
		component: login
	},
	{
		path: '/Manage',
		component: Manage,
		name: '',
		children: [{
			path: '',
			component: home,
			meta: [],
		},{
			path: '/usersInfo',
			component: usersInfo,
			meta: ['功能测试', '用户列表'],
		},
		{
			path: '/commodity',
			component: commodity,
			meta: ['功能测试', '商品'],
		},
		{
			path: '/shop',
			component: shop,
			meta: ['功能测试', '店铺'],
		},
		{
			path: '/ShopOperate',
			component: ShopOperate,
			meta: ['店铺管理', '店铺运营'],
		},{
			path: '/ShopInfo',
			component: ShopInfo,
			meta: ['店铺管理', '店铺信息'],
		},{
			path: '/ShopAddress',
			component: ShopAddress,
			meta: ['店铺管理', '地址管理'],
		},{
			path: '/Order',
			component: Order,
			meta: ['订单管理', '订单管理'],
		},{
			path: '/Release',
			component: Release,
			meta: ['商品管理', '发布商品'],
		},{
			path: '/InSale',
			component: InSale,
			meta: ['商品管理', '出售中'],
		},{
			path: '/AlreReleased',
			component: AlreReleased,
			meta: ['商品管理', '已发布'],
		},{
			path: '/NotReleased',
			component: NotReleased,
			meta: ['商品管理', '未发布'],
		},{
			path: '/LiveGoods',
			component: LiveGoods ,
			meta: ['商品管理', '直播库商品'],
		},
		{
			path: '/Customer',
			component: Customer,
			meta: ['客户管理', '客户管理'],
		},
		{
			path: '/Live',
			component: Live,
			meta: ['直播管理', '直播管理'],
		},
		{
			path: '/Freight',
			component: Freight,
			meta: ['快递设置', '运费设置'],
		},
		{
			path: '/ExpressTplt',
			component: ExpressTplt,
			meta: ['快递设置', '快递单模板'],
		}]
	}
]

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})
