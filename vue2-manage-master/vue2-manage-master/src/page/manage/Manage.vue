<template>
	<div class="manage_page fillcontain">
		<el-row style="height: 100%;">
	  		<el-col :span="4" style="min-height: 100%;background-color: #4e98a2;">
				<el-menu :default-active="defaultActive"
					style="min-height: 100%;background-color: #4e98a2;"  
					router>
					<div style="width: 100%">
						<img src="../../assets/img/logo.png" style="width: 50%;padding:10px;margin:0 auto;"/>
					</div>
					<el-menu-item index="Manage" class="navF" >
						<i class="el-icon-menu"></i>
						店铺概况
					</el-menu-item>
					
					<el-submenu index="2">
						<template slot="title">
							<i class="el-icon-document"></i>
							店铺管理
						</template>
						<el-menu-item index="ShopOperate">店铺运营</el-menu-item>
						<el-menu-item index="ShopInfo">店铺信息</el-menu-item>
						<el-menu-item index="ShopAddress">地址管理</el-menu-item>
					</el-submenu>
					
					<el-submenu index="3">
						<template slot="title">
							<i class="el-icon-plus"></i>
							订单管理
						</template>
						<el-menu-item index="Order">订单管理</el-menu-item>
					</el-submenu>
					
					<el-submenu index="4">
						<template slot="title">
							<i class="el-icon-star-on"></i>
							商品管理
						</template>
						<el-menu-item index="Release">发布商品</el-menu-item>
						<el-menu-item index="InSale">出售中</el-menu-item>
						<el-menu-item index="AlreReleased">已发布</el-menu-item>
						<el-menu-item index="NotReleased">未发布</el-menu-item>
						<el-menu-item index="LiveGoods">直播库商品</el-menu-item>
					</el-submenu>
					
					<el-submenu index="5">
						<template slot="title">
							<i class="el-icon-star-on"></i>
							客户管理
						</template>
						<el-menu-item index="Customer">客户管理</el-menu-item>
					</el-submenu>
					
					<el-submenu index="6">
						<template slot="title">
							<i class="el-icon-star-on"></i>
							直播管理
						</template>
						<el-menu-item index="Live">直播管理</el-menu-item>
					</el-submenu>

					<el-submenu index="7">
						<template slot="title">
							<i class="el-icon-warning"></i>
							快递设置
						</template>
						<el-menu-item index="Freight">运费设置</el-menu-item>
						<el-menu-item index="ExpressTplt">快递单模板</el-menu-item>
					</el-submenu>
					
					<el-submenu index="8">
						<template slot="title">
							<i class="el-icon-warning"></i>
							功能测试
						</template>
						<el-menu-item index="usersInfo">用户列表</el-menu-item>
						<el-menu-item index="commodity">商品</el-menu-item>
						<el-menu-item index="shop">店铺列表</el-menu-item>
					</el-submenu>
					
					
				</el-menu>
			</el-col>
			<el-col :span="20" style="height: 100%;overflow: auto;">
				<keep-alive>
				    <router-view></router-view>
				</keep-alive>
			</el-col>
		</el-row>
  	</div>
</template>

<script>
    export default {
		computed: {
			defaultActive: function(){
				return this.$route.path.replace('/', '');
			}
		},
    }
</script>


<style lang="less">
	@import '../../style/mixin';
	.manage_page .el-submenu .el-menu-item{
		min-width: auto;
	}
	.manage_page .navF{
		color: #FFFFFF;
		font-size: 15px;
	}
	.manage_page  .el-submenu .el-submenu__title {
	    color: #ffffff;
	    font-size: 15px;
	}
	.manage_page .el-menu-item.is-active {
	    color: #771414!important;
	    font-weight: bolder;
	    background-color: #4aa7b4;
	    font-size: 15px;
	}	 
	.manage_page .el-submenu__title:hover,
	.manage_page .el-submenu .el-menu-item:hover,
	.manage_page .navF:hover{
	    background-color: #4aa7b4;
	}
	.manage_page .el-submenu .el-menu {
	    background-color: #7cb7bf;
	}
	.manage_page .el-submenu .el-menu-item {
	    color: #fff;
	}	
</style>
