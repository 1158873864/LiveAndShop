<template>
	<div class="fillcontain">
		<head-top></head-top>
		<el-card class="box-card">
			<el-tabs v-model="activeName" @tab-click="handleClick">
			    <el-tab-pane label="商品运费模板" name="first">
			    	<el-row>
			    		<div style="margin:10px 0 20px 0;">
							<span>您已设置以下自定义运费模板</span>
							<el-button type="danger" size="small">商品运费模板</el-button>
							<span style="padding-left: 33px;font-size: 14px;">(针对单个商品有效设置的运费)</span>
						</div>
					    <el-table
						    ref="multipleTable"
						    :data="tableData3"
						    tooltip-effect="dark"
						    style="width: 100%"
						    @selection-change="handleSelectionChange">
						    <el-table-column type="selection" width="55"></el-table-column>
					    	<el-table-column prop="time" label="运费模板昵称" ></el-table-column>
					    	<el-table-column prop="time" label="说明" ></el-table-column>
					    	<el-table-column prop="time" label="发货地" ></el-table-column>
					    	<el-table-column prop="time" label="发货时间" ></el-table-column>
					  </el-table>
					</el-row>
			    </el-tab-pane>
			    <el-tab-pane label="店铺包邮条件" name="second">店铺包邮条件</el-tab-pane>
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
			activeNames: ['1'],
			tableData3: [{
	         	time:'王小虎',
	         	amount:'1'
	        },{
	         	time:'王小虎',
	         	amount:'2'
	        }]
		}
	},
	components: {
    	headTop
    },
    methods: {
      	handleClick(tab, event) {
        	console.log(tab, event);
      	},
      	handleSelectionChange(val) {
    		this.multipleSelection = val;
  		}
    }
}
</script>

<style lang="less" scoped="scoped">
	
</style>