package com.czff.mydemo.zhonglvsmUtil;

/**
 * @author cuidi
 * @description
 * @date 2023/2/20 13:49
 */
public class SmUtilTest {

    public static void main(String[] args) {

        String str = "{\"bimRequestId\":\"121321\",\"bimRemotePwd\":\"b600e7bd\",\"bimRemoteUser\":\"yunzhuUser\"},";
        String substring = str.substring(0, str.length() - 1);
        System.out.println(substring);
        StringBuilder sb = new StringBuilder("{\"bimRequestId\":\"121321\",\"bimRemotePwd\":\"b600e7bd\",\"bimRemoteUser\":\"yunzhuUser\"},");
        StringBuilder stringBuilder = sb.deleteCharAt(sb.length() - 1);
        System.out.println(stringBuilder.toString());

//        String content = "Hello world!";
//        // key必须是16位
//        String key = "JLB6L6MJVIT5Z7IL";
//        SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes());
//        String encryptHex = sm4.encryptHex(content);
//        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
//        System.out.println(encryptHex + "\r\n" + decryptStr);


//
//        String sm3 = SmUtil.sm3("Hello world!");
//        System.out.println(sm3);

//        String sm3 = SmUtil.sm3("yunzhuUser:b600e7bd");
//        System.out.println("sm3:"+sm3);
//        String strJson = "3e7f3aa8f3ee91eae7cae3ddebb557704e540c241bacfa5a5ccdc74317b10d827de9da905646f4258a78d03e9b6632fa39e90e2ac18d2fc47f25e676700e5e4de11c5885538924bbeceb31cd122c30bdb019b674d5051ef972b7f569628c4ae9ae27c4d2e378a6e4e87e1dacdac2a9803d13dc4ebb2384c6bd85c0764ba7ad861b426dd088e3c5b2987af2fa9977b16cca9b931de0a012f1583cf8b7544cbdda";
//        SymmetricCrypto sm41 = SmUtil.sm4(key.getBytes());
//        String decryptStr = sm41.decryptStr(strJson);
//        System.out.println(decryptStr);
//        String hex = sm41.encryptHex(content);
//        System.out.println(hex);

//        Class<AssetsUser> assetsUserClass = AssetsUser.class;
//        Field[] fields = assetsUserClass.getDeclaredFields();
//        ArrayList<BimAccountDTO> bimAccountList = new ArrayList<>();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            BimAccountDTO bimAccountDTO = new BimAccountDTO();
//            String name = field.getName();
//            Class<?> type1 = field.getType();
//            String name1 = field.getType().getName();
//            String type = field.getGenericType().toString();
//            bimAccountDTO.setMultivalued(false);
//            bimAccountDTO.setRequired(false);
//            bimAccountDTO.setType(type);
//            bimAccountDTO.setName(name);
//            bimAccountList.add(bimAccountDTO);
//        }
//        System.out.println(bimAccountList.toString());
    }
}
