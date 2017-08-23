package com.example.soulelegy.project_news_demo.Base;

import java.util.List;

/**
 * Created by Soul elegy on 2017/8/10.
 */

public class DataBase {
    private int error_code;
    private String reason;
    private ResultBean result;
    public int getError_code() {
        return error_code;
    }
    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public ResultBean getResult() {
        return result;
    }
    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String stat;
        private List<DataBean> data;
        public String getStat() {
            return stat;
        }
        public void setStat(String stat) {
            this.stat = stat;
        }
        public List<DataBean> getData() {
            return data;
        }
        public void setData(List<DataBean> data) {
            this.data = data;
        }
        public static class DataBean {
            /**
             * author_name : 新华社
             * category : 头条
             * date : 2017-08-10 19:05
             * thumbnail_pic_s : http://06.imgmini.eastday.com/mobile/20170810/20170810190551_4d2898319a0654d9e3004e0dbe3fd395_2_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://06.imgmini.eastday.com/mobile/20170810/20170810190551_151c3bc00c4f4c642ad3862bd6d2e983_8_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://06.imgmini.eastday.com/mobile/20170810/20170810190551_48a7e0d995d7a5b7ed24d28204e03051_4_mwpm_03200403.jpg
             * title : 乘“丝路”之风 扬“金砖”之帆——海陆丝绸之路在厦门交汇携手
             * uniquekey : 083a97b7480db52478e2b3158bf1a48d
             * url : http://mini.eastday.com/mobile/170810190551661.html
             */

            //名字
            private String author_name;
            //标注
            private String category;
            //日期
            private String date;
            //图片一
            private String thumbnail_pic_s;
            //图片二
            private String thumbnail_pic_s02;
            //图片三
            private String thumbnail_pic_s03;
            //标题
            private String title;
            //key
            private String uniquekey;
            //路径
            private String url;

            public String getAuthor_name() {
                return author_name;
            }
            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }
            public String getCategory() {
                return category;
            }
            public void setCategory(String category) {
                this.category = category;
            }
            public String getDate() {
                return date;
            }
            public void setDate(String date) {
                this.date = date;
            }
            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }
            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }
            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }
            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }
            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }
            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
            public String getTitle() {
                return title;
            }
            public void setTitle(String title) {
                this.title = title;
            }
            public String getUniquekey() {
                return uniquekey;
            }
            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }
            public String getUrl() {
                return url;
            }
            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
