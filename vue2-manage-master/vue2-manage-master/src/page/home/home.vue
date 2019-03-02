<template>
    <div>
        <head-top></head-top>
        <el-card class="box-card" >
        	<div style="margin-bottom: 20px;">
        		<h3 class="title-h3">综合数据</h3>
        		<el-row class="multiple-data">
					<el-col :span="4" style="background: #4ebeb2;">
				  		<div class="mul mul-left">
				  			<i class="el-icon-star-on"></i>
				  		</div>
				  		<div class="mul mul-right">
				  			<span>总销售额</span><br/>
				  			<em>0</em>&nbsp;元
				  		</div>
					</el-col>
					<el-col :span="4" style="background: #53a273;">
					  	<div class="mul mul-left">
				  			<i class="el-icon-star-on"></i>
				  		</div>
				  		<div class="mul mul-right">
				  			<span>总订单数</span><br/>
				  			<em>1</em>&nbsp;单
				  		</div>
					</el-col>
					<el-col :span="4" style="background: #d2955c;">
					  	<div class="mul mul-left">
				  			<i class="el-icon-star-on"></i>
				  		</div>
				  		<div class="mul mul-right">
				  			<span>总收藏数</span><br/>
				  			<em>2</em>&nbsp;件
				  		</div>
					</el-col>
					<el-col :span="4" style="background: #4e98a2;">
					  	<div class="mul mul-left">
				  			<i class="el-icon-star-on"></i>
				  		</div>
				  		<div class="mul mul-right">
				  			<span>总粉丝数</span><br/>
				  			<em>3</em>&nbsp;人
				  		</div>
					</el-col><el-col :span="4" style="background: #c88d46;">
					  	<div class="mul mul-left">
				  			<i class="el-icon-star-on"></i>
				  		</div>
				  		<div class="mul mul-right">
				  			<span>总购物车商品</span><br/>
				  			<em>4</em>&nbsp;件
				  		</div>
					</el-col>
				</el-row>
        	</div>
        	<div>
        		<h3 class="title-h3">待处理事项</h3>
        		<el-tabs v-model="activeName" @tab-click="handleClick">
				    <el-tab-pane label="待发货" name="first">
				    	<el-table :data="tableData" style="width: 100%">
					      	<el-table-column prop="goodname" label="拍下宝贝"></el-table-column>
						    <el-table-column prop="goodid" label="订单编号"></el-table-column>
					      	<el-table-column prop="gooduser" label="买家"></el-table-column>
					      	<el-table-column prop="goodmoney" label="实收款"></el-table-column>
					      	<el-table-column prop="goodstatus" label="订单状态"></el-table-column>
			   			</el-table>	
				    </el-tab-pane>
				    <el-tab-pane label="退款待处理" name="second">
				    	暂无数据
				    </el-tab-pane>
				    <el-tab-pane label="待商家收货" name="third">
				    	暂无数据
				    </el-tab-pane>
				</el-tabs>
        	</div>
        </el-card>
        
    </div>
</template>

<script>
	import headTop from '../../components/headTop'
    export default {
    	data(){
    		return {
    			activeName: 'first',
    			tableData: [
					{
			          	goodname: '书包',
			          	goodid: '0011',
			          	gooduser: '小明',
			          	goodmoney: '123',
			          	goodstatus: '打包中'
			        }
        		]
    		}
    	},
    	components: {
    		headTop
    	},
    	mounted(){

    	},
        computed: {

        },
    	methods: {
	    	handleClick(tab, event) {
		        console.log(tab, event);
		    }	
    	}
    }
</script>

<style lang="less" scoped="scoped">
	@import '../../style/mixin';
	.multiple-data > .el-col-4 {
		border: 1px solid #FFFFFF;
	    border-radius: 10px;
	    height: 105px;
	}
	.multiple-data > .el-col-4:not(last-child){
		margin-right: 20px;
	}
	.multiple-data{
		padding:20px 0px;
		.el-col-4{
			font-size:0;
			padding:5px 15px;
			display: flex;
			.mul{
			    display: inline-block;
			    vertical-align: top;
			    color: #fff;
			    font-size: 14px;
			    span{
			    	display: block;
			    	margin-top: 8px;
			    }
			    em{
			    	font-style: normal;
			    }
			}
		}
	}
	.multiple-data .el-col-4 .mul-left{
		font-size:30px;
		width: 40%;
	}
	.multiple-data .el-col-4 .mul-right{
		width: 60%;
		text-align: right;
	}
	.title-h3{
		color: #409EFF;
		padding-left: 3px;
	}
	.el-tabs{
		margin:20px 0;
	}
</style>
