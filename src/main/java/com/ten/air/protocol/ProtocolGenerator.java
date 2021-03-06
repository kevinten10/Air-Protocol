package com.ten.air.protocol;

/**
 * Protocol 生成器
 */
public class ProtocolGenerator {

    /**
     * 生成模拟数据
     */
    public static String genMockProtocol(String imei) {
        return ProtocolEncode.genHexProtocol(imei, AirIndex.getNewAir());
    }

    /* --------------------------------------------------------------------- */

    /**
     * 大气质量指标
     */
    static class AirIndex {

        private String temperature;
        private String humi;
        private String pm25;
        private String undef;

        /**
         * 基础数据 :随机数据在BASE上下波动
         */
        private static final Integer BASE_TEMPERATURE = 25;
        private static final Integer BASE_HUMI = 15;
        private static final Integer BASE_PM25 = 350;
        private static final Integer BASE_UNDEF = 350;

        /**
         * 获取一个新的空气指标记录，将随机生成相关参数
         */
        static AirIndex getNewAir() {
            AirIndex airIndex = new AirIndex();

            String temperature = String.valueOf(Math.random() > 0.5f ? BASE_TEMPERATURE + Math.random() * 10 : BASE_TEMPERATURE - Math.random() * 10);
            String humi = String.valueOf(Math.random() > 0.5f ? BASE_HUMI + Math.random() * 5 : BASE_HUMI - Math.random() * 5);
            String pm25 = String.valueOf(Math.random() > 0.5f ? BASE_PM25 + Math.random() * 100 : BASE_PM25 - Math.random() * 100);
            String undef = String.valueOf(Math.random() > 0.5f ? BASE_UNDEF + Math.random() * 100 : BASE_UNDEF - Math.random() * 100);

            airIndex.setTemperature(temperature);
            airIndex.setHumi(humi);
            airIndex.setPm25(pm25);
            airIndex.setUndef(undef);

//            System.out.println(airIndex);

            return airIndex;
        }

        private AirIndex() {
        }

        @Override
        public String toString() {
            return "AirIndex{" +
                    "temperature='" + temperature + '\'' +
                    ", humi='" + humi + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    ", undef='" + undef + '\'' +
                    '}';
        }

        String getHumi() {
            return humi;
        }

        void setHumi(String humi) {
            this.humi = humi;
        }

        String getUndef() {
            return undef;
        }

        void setUndef(String undef) {
            this.undef = undef;
        }

        String getTemperature() {
            return temperature;
        }

        void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        String getPm25() {
            return pm25;
        }

        void setPm25(String pm25) {
            this.pm25 = pm25;
        }
    }

}
