<template>
	<div class="shop-info">
		<head-top></head-top>
		<el-card class="box-card">
			<el-tabs v-model="activeName" @tab-click="handleClick">
			    <el-tab-pane label="店铺主页装修" name="first">
			    	<el-row>
					    <el-col :span="12" style="text-align: center;">
					    	<img src="../../assets/img/phone.jpg" style="width:50%;"/>
					    </el-col>
					    <el-col :span="12">
					    	<div class="grid-content bg-purple-light">
					    		<el-collapse v-model="activeNames" @change="handleChange">
								  	<el-collapse-item title="详细信息" name="1">
									    <div>
									    	展示视屏
									    	<span>状态</span>
									    </div>
									    <div>
									    	展示视屏
									    	<span>状态</span>
									    </div>
									    <div>
									    	展示视屏
									    	<span>状态</span>
									    </div>
									    <div>
									    	展示视屏
									    	<span>状态</span>
									    </div>
								  	</el-collapse-item>
								  	<el-collapse-item title="栏目名称" name="2">
									    <div>暂无信息</div>
								  	</el-collapse-item>
								</el-collapse>
					    	</div>
					    </el-col>
					</el-row>
			    </el-tab-pane>
			    <el-tab-pane label="店铺经营信息" name="second">店铺经营信息</el-tab-pane>
			    <el-tab-pane label="店铺认证信息" name="third">店铺认证信息</el-tab-pane>
		  	</el-tabs>
	  	</el-card>
	</div>
</template>

<script>
import headTop from '../../components/headTop'

export default{
	data () {
		return{
			activeName: 'first',
			activeNames: ['1']
		}
	},
	components: {
    	headTop
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
}
</script>

<style lang="less" scoped="scoped">
	.shop-info{

	}
</style>