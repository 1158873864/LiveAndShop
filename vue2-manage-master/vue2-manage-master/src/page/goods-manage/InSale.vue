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
				  	<el-form-item label="价格">
				    	<el-select v-model="aformInline.d" placeholder="价格">
					      	<el-option label="从低到高" value="从低到高"></el-option>
					      	<el-option label="从高到低" value="从高到低"></el-option>
					      	<el-option label="从高到低" value="综合排序"></el-option>
					    </el-select>
				  	</el-form-item>
				  	<el-form-item>
				    	<el-button type="primary" @click="onSubmit">查询</el-button>
				  	</el-form-item>
				</el-form>
				<!--时间筛选-->
				<el-form :inline="true" :model="bformInline" class="demo-form-inline">
					<span>上架时间</span>
					<el-date-picker
				      v-model="bformInline.value5"
				      type="datetimerange"
				      :picker-options="pickerOptions2"
				      range-separator="至"
				      start-placeholder="开始日期"
				      end-placeholder="结束日期"
				      align="right">
				    </el-date-picker>
				</el-form>
				
				<el-form :inline="true" :model="cformInline" class="demo-form-inline">
					<el-form-item label="批量操作">
				    <el-checkbox-group v-model="cformInline.a">
				      	<el-checkbox label="删除" name="type"></el-checkbox>
				      	<el-checkbox label="上架" name="type"></el-checkbox>
				      	<el-checkbox label="下架" name="type"></el-checkbox>
				    </el-checkbox-group>
				  </el-form-item>
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
		    	<el-table-column prop="time" label="上架时间" ></el-table-column>
		    	<el-table-column prop="amount" label="价格" sortable></el-table-column>
		    	<el-table-column prop="time" label="库存" ></el-table-column>
		    	<el-table-column prop="time" label="销量" ></el-table-column>
		    	<el-table-column prop="time" label="产品链接" ></el-table-column>
		    	<el-table-column label="操作" width="240">
	                <template slot-scope="scope">
	                	<el-button type="danger" size="mini">加入直播库</el-button>
	                	<el-button type="danger" size="mini">下架</el-button>
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
            	bformInline:{
            		value5:''
            	},
            	cformInline:{
            		a:[]
            	},
            	pickerOptions2: {
		          	shortcuts: [{
			            text: '最近一周',
			            onClick(picker) {
			              	const end = new Date();
			              	const start = new Date();
			              	start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
			              	picker.$emit('pick', [start, end]);
			            }
			        }, {
			            text: '最近一个月',
			            onClick(picker) {
			              	const end = new Date();
		              		const start = new Date();
			              	start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
			              	picker.$emit('pick', [start, end]);
			            }
			        }, {
			            text: '最近三个月',
			            onClick(picker) {
			              	const end = new Date();
			              	const start = new Date();
			              	start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
			              	picker.$emit('pick', [start, end]);
			            }
		          	}],
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
