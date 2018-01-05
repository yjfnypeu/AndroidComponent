package com.lzh.zhihunewscomponent.pojo;

import java.util.List;

/**
 * @author haoge on 2018/1/5.
 */

public class NewsList {

    /**
     * date : 20180105
     * stories : [{"images":["https://pic3.zhimg.com/v2-e0a9a59d5a3115af64a6792a969dbd82.jpg"],"type":0,"id":9664295,"ga_prefix":"010517","title":"「你跳槽吧，1-2 年后跳回来，开价多少都可以谈」"},{"images":["https://pic1.zhimg.com/v2-bf504cec954f1530d1b01b1d67621fd4.jpg"],"type":0,"id":9664273,"ga_prefix":"010516","title":"全民答题这类直播 app 到底能不能火起来？"},{"images":["https://pic4.zhimg.com/v2-e55141776de84faad32ceb64211f154b.jpg"],"type":0,"id":9664054,"ga_prefix":"010515","title":"《今日说法》主持人不满信用卡高额利息，官司是赢了，规则会改吗？"},{"title":"为什么你玩「跳一跳」会上瘾？","ga_prefix":"010513","images":["https://pic2.zhimg.com/v2-ec611879ce2548de1330928c9d7c8d2d.jpg"],"multipic":true,"type":0,"id":9664265},{"images":["https://pic3.zhimg.com/v2-a6e8b94f4d57e8c2a5762fcc706bde8e.jpg"],"type":0,"id":9663823,"ga_prefix":"010512","title":"大误 · 怎么写出那种日式中二病的歌？"},{"images":["https://pic4.zhimg.com/v2-c473b22644ca672d3fb845ec32578513.jpg"],"type":0,"id":9664154,"ga_prefix":"010510","title":"感冒发烧的人越来越多了，冬天怎么预防流感最有用？"},{"images":["https://pic2.zhimg.com/v2-7f262322ddc2c92d19a933d146d9ae81.jpg"],"type":0,"id":9663904,"ga_prefix":"010509","title":"期末考复习来不及了？教你个办法，说不定还能挽救一下"},{"images":["https://pic4.zhimg.com/v2-54b453a3771181c44fc212b6ae53b0d3.jpg"],"type":0,"id":9664108,"ga_prefix":"010508","title":"从盛名到骂名：算法的  2017 和走在十字路口的科技公司们"},{"title":"我家狗真能听懂我说的话，还是我自作多情？","ga_prefix":"010507","images":["https://pic2.zhimg.com/v2-f2bad5254bab49e9ca247bd88e2e44fd.jpg"],"multipic":true,"type":0,"id":9664169},{"images":["https://pic4.zhimg.com/v2-e5c60afc61c01eadae7aba2acd34f45f.jpg"],"type":0,"id":9664147,"ga_prefix":"010507","title":"「转行人工智能」是否前景一片光明？"},{"title":"2017 年度盘点 · 中国出现了哪些有意思的消费升级现象？","ga_prefix":"010507","images":["https://pic2.zhimg.com/v2-7c04b73e85179d8881133675ad22412d.jpg"],"multipic":true,"type":0,"id":9664178},{"images":["https://pic3.zhimg.com/v2-4b09246727ecedbc218eeee4e980531a.jpg"],"type":0,"id":9664110,"ga_prefix":"010506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-824da04e95f179a7dbec182e67ae1d80.jpg","type":0,"id":9664273,"ga_prefix":"010516","title":"全民答题这类直播 app 到底能不能火起来？"},{"image":"https://pic1.zhimg.com/v2-34c209b30d3327a0729714d181907598.jpg","type":0,"id":9664265,"ga_prefix":"010513","title":"为什么你玩「跳一跳」会上瘾？"},{"image":"https://pic4.zhimg.com/v2-054435e932b18ce8ab328769a6dd2aa3.jpg","type":0,"id":9664054,"ga_prefix":"010515","title":"《今日说法》主持人不满信用卡高额利息，官司是赢了，规则会改吗？"},{"image":"https://pic3.zhimg.com/v2-5fde63360456bd59fa30b25d203c5d8e.jpg","type":0,"id":9664154,"ga_prefix":"010510","title":"感冒发烧的人越来越多了，冬天怎么预防流感最有用？"},{"image":"https://pic1.zhimg.com/v2-3bad44157039503bd4b57b3e9753ad44.jpg","type":0,"id":9664108,"ga_prefix":"010508","title":"从盛名到骂名：算法的  2017 和走在十字路口的科技公司们"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static class StoriesBean {
        /**
         * images : ["https://pic3.zhimg.com/v2-e0a9a59d5a3115af64a6792a969dbd82.jpg"]
         * type : 0
         * id : 9664295
         * ga_prefix : 010517
         * title : 「你跳槽吧，1-2 年后跳回来，开价多少都可以谈」
         * multipic : true
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public boolean multipic;
        public List<String> images;
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-824da04e95f179a7dbec182e67ae1d80.jpg
         * type : 0
         * id : 9664273
         * ga_prefix : 010516
         * title : 全民答题这类直播 app 到底能不能火起来？
         */

        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }
}
