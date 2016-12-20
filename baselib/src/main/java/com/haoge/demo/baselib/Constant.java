package com.haoge.demo.baselib;

public final class Constant {

    /**
     * 对各个模块用于生成路由映射表的生成类包名定义。让各自的组件中生成的映射表都对应使用各自的package。
     * <p>
     *     对Activity使用{@link com.lzh.nonview.router.anno.RouterRule} 注解。指定pack报名。即可
     * </p>
     */
    public static final class PACK {
        public static final String USERCENTER = "com.jm.android.app.usercenter";
        public static final String SOCIAL = "com.jm.android.app.social";

        /**
         * JMRouteManager中使用此数组数据来加载所有的路由映射表。
         */
        public static final String[] Packages = new String[] {USERCENTER,SOCIAL};
    }

}
