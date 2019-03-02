<template>
	<div class="shop-operate">
		<head-top></head-top>
		<el-card class="box-card listtable" >
			<el-tabs v-model="activeName" @tab-click="handleClick" type="border-card" style="border: none;">
			    <el-tab-pane label="销售额" name="first">
			    1		
			    </el-tab-pane>
			    <el-tab-pane label="成交订单数" name="second">
		    	  	<el-radio-group style="margin-bottom: 30px;">
		    	  		<el-radio-button label="今天"></el-radio-button>
					    <el-radio-button label="近7天"></el-radio-button>
					    <el-radio-button label="近30天"></el-radio-button>
					    <el-radio-button label="本月"></el-radio-button>
					    <el-radio-button label="上月"></el-radio-button>
					</el-radio-group>
					<el-row>
					    <el-col :span="12">
					    	1
					    </el-col>
					  	<el-col :span="12">
					  		2
					  	</el-col>
					</el-row>
					
			    </el-tab-pane>
			</el-tabs>
		
		</el-card>
	</div>
</template>

<script>
import headTop from '../../components/headTop'

export default{
	data () {
		return{
			activeName: 'second',
			
		}
	},
	components: {
    	headTop
   	},
   	methods:{
		handleClick(tab, event) {
	        console.log(tab, event);
	    }
   	}
}
</script>

<style lang="less" scoped="scoped">
	.shop-operate .shop-diver /deep/ .el-tabs__item.is-active {
	    color: #ffffff;
	    background: #20a0ff;
	}
</style>