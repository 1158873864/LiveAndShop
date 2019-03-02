<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-card class="box-card listtable" >
        	<div slot="header" class="clearfix">
	        	<!--搜索商品-->
	        	<el-form :inline="true" :model="aformInline" class="demo-form-inline">
				  	<el-form-item label="商品名称">
				    	<el-input v-model="aformInline.a" placeholder="商品名称"></el-input>
				  	</el-form-item>
				  	<el-form-item label="店铺中分类">
				    	<el-select v-model="aformInline.b" placeholder="店铺中分类">
					      	<el-option label="男性" value="男性"></el-option>
					      	<el-option label="女性" value="女性"></el-option>
					    </el-select>
				  	</el-form-item>
				  	<el-form-item label="商品类型">
				    	<el-select v-model="aformInline.c" placeholder="商品类型">
					      	<el-option label="衣服" value="衣服"></el-option>
					      	<el-option label="食品" value="食品"></el-option>
					    </el-select>
				  	</el-form-item>
				  	<el-form-item>
				    	<el-button type="primary" @click="onSubmit">查询</el-button>
				  	</el-form-item>
				  	
				  	<el-form :inline="true" :model="cformInline" class="demo-form-inline">
						<el-form-item label="批量操作">
						    <el-checkbox-group v-model="cformInline.a">
						      	<el-button type="primary" size="small">发布</el-button>
	                			<el-button type="danger" size="small">删除</el-button>
						    </el-checkbox-group>
					 	 </el-form-item>
					</el-form>
				</el-form>
	        </div>    
	        
	        <el-table
			    ref="multipleTable"
			    :data="tableData3"
			    tooltip-effect="dark"
			    style="width: 100%"
			    @selection-change="handleSelectionChange">
			    <el-table-column type="selection" width="55"></el-table-column>
		    	<el-table-column prop="time" label="商品名称" ></el-table-column>
		    	<el-table-column prop="time" label="类目" ></el-table-column>
		    	<el-table-column prop="amount" label="价格" sortable></el-table-column>
		    	<el-table-column prop="time" label="库存" ></el-table-column>
		    	<el-table-column prop="time" label="产品链接" ></el-table-column>
		    	<el-table-column label="操作" width="240">
	                <template slot-scope="scope">
	                	<el-button type="primary" size="mini">发布</el-button>
	                	<el-button type="danger" size="mini">删除</el-button>
	                    <el-button
	                      	size="mini"
	                      	@click="handleEdit(scope.$index, scope.row)">编辑
	                    </el-button>
	                </template>
	            </el-table-column>
		  </el-table>
	        
		</el-card>	
       
        
    </div>
</template>

<script>
    import headTop from '../../components/headTop'
    import {baseUrl, baseImgPath} from '@/config/env'
    import { } from '@/api/getData'
    export default {
        data(){
            return {
            	aformInline: {
            		a:'',
            		b:'',
            		c:'',
            		d:''
            	},
            	cformInline:{
            		a:[]
            	},
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
    		headTop,
    	},
    	methods:{
    		onSubmit(){
    			console.log("提交")
    		},
    		handleSelectionChange(val) {
        		this.multipleSelection = val;
      		}
    	}
    }
</script>

<style lang="less" scoped="scoped">
	@import '../../style/mixin';
	.fillcontain{
		
	}
	
    
</style>
