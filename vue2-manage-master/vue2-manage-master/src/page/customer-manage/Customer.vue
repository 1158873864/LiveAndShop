<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-card class="box-card listtable" >
        	<div slot="header" class="clearfix">
	        	<!--搜索商品-->
	        	<el-form :inline="true" :model="aformInline" class="demo-form-inline">
				  	<el-form-item label="客户昵称">
				    	<el-input v-model="aformInline.a" placeholder="客户昵称"></el-input>
				  	</el-form-item>
				  	<el-form-item label="手机号">
					    <el-input v-model="aformInline.b" placeholder="手机号"></el-input>
				  	</el-form-item>
				  	<el-form-item label="性别筛选">
				    	<el-select v-model="aformInline.c" placeholder="性别筛选">
					      	<el-option label="男" value="男"></el-option>
					      	<el-option label="女" value="女"></el-option>
					    </el-select>
				  	</el-form-item>
				  	<el-form-item label="购买总额">
				    	<el-select v-model="aformInline.d" placeholder="购买总额">
					      	<el-option label="100以上" value="100以上"></el-option>
					      	<el-option label="200以上" value="200以上"></el-option>
					      	<el-option label="300以上" value="300以上"></el-option>
					    </el-select>
				  	</el-form-item>
				  	<el-form-item>
				    	<el-button type="primary" @click="onSubmit">查询</el-button>
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
		    	<el-table-column prop="time" label="客户昵称" ></el-table-column>
		    	<el-table-column prop="time" label="手机号" ></el-table-column>
		    	<el-table-column prop="time" label="性别" ></el-table-column>
		    	<el-table-column prop="time" label="购买总额" ></el-table-column>
		    	<el-table-column label="操作" width="240">
	                <template slot-scope="scope">
	                	<el-button type="danger" size="mini">拨打电话</el-button>
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
