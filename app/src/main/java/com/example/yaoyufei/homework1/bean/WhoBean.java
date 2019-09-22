package com.example.yaoyufei.homework1.bean;

import java.util.List;

public class WhoBean {

    /**
     * code : 200
     * body : {"result":[{"teacherpowerid":"0","description":"介绍"},{"teacherpowerid":1,"description":"课程"},{"teacherpowerid":"3","description":"专题"}]}
     * message : Succes!
     */
    private int code;
    private BodyEntity body;
    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setBody(BodyEntity body) {
        this.body = body;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public BodyEntity getBody() {
        return body;
    }

    public String getMessage() {
        return message;
    }

    public class BodyEntity {
        /**
         * result : [{"teacherpowerid":"0","description":"介绍"},{"teacherpowerid":1,"description":"课程"},{"teacherpowerid":"3","description":"专题"}]
         */
        private List<ResultEntity> result;

        public void setResult(List<ResultEntity> result) {
            this.result = result;
        }

        public List<ResultEntity> getResult() {
            return result;
        }

        public class ResultEntity {
            /**
             * teacherpowerid : 0
             * description : 介绍
             */
            private String teacherpowerid;
            private String description;

            public void setTeacherpowerid(String teacherpowerid) {
                this.teacherpowerid = teacherpowerid;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTeacherpowerid() {
                return teacherpowerid;
            }

            public String getDescription() {
                return description;
            }
        }
    }
}
