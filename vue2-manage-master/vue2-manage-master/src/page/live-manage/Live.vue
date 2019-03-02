<template>
    <div class="fillcontain">
        <head-top></head-top>
        <el-card class="box-card listtable" >
        	<div slot="header" class="clearfix">
	        	直播未开启
	        </div>
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
            
            }
    	},
    	components: {
    		headTop,
    	},
    	methods:{
    		
    	}
    }
</script>

<style lang="less" scoped="scoped">
	@import '../../style/mixin';
	.fillcontain{
		
	}
	
    
</style>
