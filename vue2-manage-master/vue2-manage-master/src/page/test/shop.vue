<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-card class="box-card listtable" >
        	
	        <!--店铺列表-->
	        <div class="table_container">
	            <el-table :data="tableData" highlight-current-row style="width: 100%">
	            	<!--列表详情-->
					<el-table-column type="expand">
				      	<template slot-scope="props">
					        <el-form label-position="left" inline class="demo-table-expand">
						        <el-form-item label="店铺...">
						            <span>{{ props.row.AllShop  }}11</span>
						        </el-form-item>
					        </el-form>
				      	</template>
				    </el-table-column>
	                <el-table-column type="index" width="50"></el-table-column>
	                <el-table-column property="AllShop " label="店铺1" ></el-table-column>
	            </el-table>
	        </div> 
	        
		</el-card>	
        
    </div>
</template>

<script>
    import headTop from '../../components/headTop'
    import {baseUrl, baseImgPath} from '@/config/env'
    import {getQueryAllShop} from '@/api/getData'
    export default {
        data(){
            return {
                tableData: [{
                	commodity:'1'
                }],
                offset: 0,
                limit: 20,
            }
        },
    	components: {
    		headTop,
    	},
        created(){
        	
        },
        methods: {
        	handleClose(done){
        		done();
        	},
            //搜索商品
            onSubmit() {
		        alert('submit!');
		    },
            //fetch获取商品信息
            async getallshop(){
                const Users = await getQueryAllShop({offset: this.offset, limit: this.limit});
                this.tableData = [];
                Users.forEach(item => {
                    const tableData = {};
					tableData.commodity = item.commodity;					
                    this.tableData.push(tableData);
                })
                console.log("获取店铺信息成功")
            }
        }
    }
</script>

<style lang="less" scoped="scoped">
	@import '../../style/mixin';
	.fillcontain{
		.searchusers{
			.el-form-item{
				margin-right: 10px;
				margin-bottom: 5px;
				.el-form-item__label {
				    padding: 11px 4px 11px 0px;
				}
			}
		}
		
	}
	
    
</style>
