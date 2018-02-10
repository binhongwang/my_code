package com.kobe.signed.model;

import java.util.List;

/**
 * Created by zhao on 2018/1/23.
 */

public class SignInfoModel {

    /**
     * data : {"nickname":"路大大","score":105364559,"money":998810,"signed_days":1,"last_signed_date":"2018-01-22","is_signed":1,"is_signed_msg":"已连续签到1天, 明天签到可得500金币","sign_settings":[{"sign_id":1,"type":1,"sign_name":"连续1","days":1,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":2,"type":1,"sign_name":"连续2","days":2,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":3,"type":1,"sign_name":"连续3","days":3,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":4,"type":1,"sign_name":"连续4","days":4,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":5,"type":1,"sign_name":"连续5","days":5,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":6,"type":1,"sign_name":"连续6","days":6,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":7,"type":2,"sign_name":"连续7","days":7,"rewards":5,"rewards_msg":"+5钻石"},{"sign_id":8,"type":1,"sign_name":"连续8","days":8,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":9,"type":1,"sign_name":"连续9","days":9,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":10,"type":1,"sign_name":"连续10","days":10,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":11,"type":1,"sign_name":"连续11","days":11,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":12,"type":1,"sign_name":"连续12","days":12,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":13,"type":1,"sign_name":"连续13","days":13,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":14,"type":2,"sign_name":"连续14","days":14,"rewards":10,"rewards_msg":"+10钻石"},{"sign_id":15,"type":1,"sign_name":"连续15","days":15,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":16,"type":1,"sign_name":"连续16","days":16,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":17,"type":1,"sign_name":"连续17","days":17,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":18,"type":1,"sign_name":"连续18","days":18,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":19,"type":1,"sign_name":"连续19","days":19,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":20,"type":1,"sign_name":"连续20","days":20,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":21,"type":2,"sign_name":"连续21","days":21,"rewards":20,"rewards_msg":"+20钻石"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nickname : 路大大
         * score : 105364559
         * money : 998810
         * signed_days : 1
         * last_signed_date : 2018-01-22
         * is_signed : 1
         * is_signed_msg : 已连续签到1天, 明天签到可得500金币
         * sign_settings : [{"sign_id":1,"type":1,"sign_name":"连续1","days":1,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":2,"type":1,"sign_name":"连续2","days":2,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":3,"type":1,"sign_name":"连续3","days":3,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":4,"type":1,"sign_name":"连续4","days":4,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":5,"type":1,"sign_name":"连续5","days":5,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":6,"type":1,"sign_name":"连续6","days":6,"rewards":500,"rewards_msg":"+500金币"},{"sign_id":7,"type":2,"sign_name":"连续7","days":7,"rewards":5,"rewards_msg":"+5钻石"},{"sign_id":8,"type":1,"sign_name":"连续8","days":8,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":9,"type":1,"sign_name":"连续9","days":9,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":10,"type":1,"sign_name":"连续10","days":10,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":11,"type":1,"sign_name":"连续11","days":11,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":12,"type":1,"sign_name":"连续12","days":12,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":13,"type":1,"sign_name":"连续13","days":13,"rewards":1000,"rewards_msg":"+1000金币"},{"sign_id":14,"type":2,"sign_name":"连续14","days":14,"rewards":10,"rewards_msg":"+10钻石"},{"sign_id":15,"type":1,"sign_name":"连续15","days":15,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":16,"type":1,"sign_name":"连续16","days":16,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":17,"type":1,"sign_name":"连续17","days":17,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":18,"type":1,"sign_name":"连续18","days":18,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":19,"type":1,"sign_name":"连续19","days":19,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":20,"type":1,"sign_name":"连续20","days":20,"rewards":2000,"rewards_msg":"+2000金币"},{"sign_id":21,"type":2,"sign_name":"连续21","days":21,"rewards":20,"rewards_msg":"+20钻石"}]
         */

        private String nickname;
        private int score;
        private int money;
        private int signed_days;
        private String last_signed_date;
        private int is_signed;
        private String is_signed_msg;
        private List<SignSettingsBean> sign_settings;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getSigned_days() {
            return signed_days;
        }

        public void setSigned_days(int signed_days) {
            this.signed_days = signed_days;
        }

        public String getLast_signed_date() {
            return last_signed_date;
        }

        public void setLast_signed_date(String last_signed_date) {
            this.last_signed_date = last_signed_date;
        }

        public int getIs_signed() {
            return is_signed;
        }

        public void setIs_signed(int is_signed) {
            this.is_signed = is_signed;
        }

        public String getIs_signed_msg() {
            return is_signed_msg;
        }

        public void setIs_signed_msg(String is_signed_msg) {
            this.is_signed_msg = is_signed_msg;
        }

        public List<SignSettingsBean> getSign_settings() {
            return sign_settings;
        }

        public void setSign_settings(List<SignSettingsBean> sign_settings) {
            this.sign_settings = sign_settings;
        }

        public static class SignSettingsBean {
            /**
             * sign_id : 1
             * type : 1
             * sign_name : 连续1
             * days : 1
             * rewards : 500
             * rewards_msg : +500金币
             */

            private int sign_id;
            private int type;
            private String sign_name;
            private int days;
            private int rewards;
            private String rewards_msg;

            public int getSign_id() {
                return sign_id;
            }

            public void setSign_id(int sign_id) {
                this.sign_id = sign_id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getSign_name() {
                return sign_name;
            }

            public void setSign_name(String sign_name) {
                this.sign_name = sign_name;
            }

            public int getDays() {
                return days;
            }

            public void setDays(int days) {
                this.days = days;
            }

            public int getRewards() {
                return rewards;
            }

            public void setRewards(int rewards) {
                this.rewards = rewards;
            }

            public String getRewards_msg() {
                return rewards_msg;
            }

            public void setRewards_msg(String rewards_msg) {
                this.rewards_msg = rewards_msg;
            }
        }
    }
}
