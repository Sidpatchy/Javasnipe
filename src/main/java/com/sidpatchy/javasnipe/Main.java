package com.sidpatchy.javasnipe;

import com.sidpatchy.javasnipe.Bean.Asset.Asset;
import com.sidpatchy.javasnipe.Bean.Enum.Order;
import com.sidpatchy.javasnipe.Bean.Enum.Sort;
import com.sidpatchy.javasnipe.Bean.Generic.GenericField;
import com.sidpatchy.javasnipe.Module.AssetModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
//        SnipeAPI api = new SnipeAPIBuilder()
//                .setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNWQxYTFkNDhkOWU0YTIzYzlmMWZkZjAxNDdkZjIxZmVjNzlmNmJhNTg4MmViZTc3ZDkyMTM5MmQ0ZDc1ODU1MjcyZTc3ZjE1M2Q0MWZiODQiLCJpYXQiOjE3NDM0MzY0OTYuNTU5OTgzLCJuYmYiOjE3NDM0MzY0OTYuNTU5OTg2LCJleHAiOjIyMTY4MjIwOTYuNTUzOTU5LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.QwttmsDtOEzN1Kq2jiXpgxKBQ4tA1cEwDcHi20Jzx0pRJZsnRB1FjDE4hDXDY6N1OsOt8XxuCTvRp87t7Brhu1BDgt--toN3nuGhiZzCjzkR4SWCY8vJSei1Z1UdQxJKOoZRZFkrNw_I0PkGb8PjaEsSMs9fDhiYKl-7Y0tVU6W39liA_dZxLg9QiwR8jhHiZOUGj6z0xqluNSGyxQweNMJp9ECFPe837SqyHX7RSlfnFt1GHP0SEx8jfqVoZiYLuEL5FL4JPcBvHwF1Ey8rDzTpbMwIYi8UgIAFR6evNxqBCjIgw58aGcY8eodKWjMe-j5-4E-m78h0WzYZTBJcN9AUYmUNtyFgvBWIpgSjxGlT5M64112sTFk6xS6qumWQQjaxeNVnNwbzqz9Za-kfYl9i4IR1U4C5JSp11NzY5ZCEWiTfVYOQYKb3bt4J8yEQtjccWUZ4Na-bcr02fW6JWzhczpOU_jaIy88uZYVKYw7R73QmZa2qxQm_gBTPeEmYYgaXX1VP-e4HX9Y9BxM4dbYRWqqX71MfM7vU4Q6fjrKmplqxzJZ_kRY5als5ZP_8CSBVYXSS6oDydsIYK9Ywpb2yokc7Rt8YplkreObHpQS6Qd6pC7ZhrhIUMocIHWosJVQTk7ZM57GQgOLcgpdWcvaZuwWU2aVZUZSodhaFAuo")
//                .setApiEndpoint("http://10.0.0.176/api/v1")
//                .build();

        // Get all assets
        //List<Asset> assets = api.getAssetList(Sort.ASSET_TAG, Order.ASCENDING).join();

//        // Loop through list of assets
//        for (Asset asset : assets) {
//            int assetID = asset.getId().orElse(-1);
//
//            logger.info(assetID);
//
//            Asset asset2 = api.getAssetByID(String.valueOf(assetID)).join();
//
//            GenericField assignedTo = asset2.getAssignedTo().orElse(null);
//
//            if (assignedTo != null) {
//                logger.fatal(assignedTo.getName());
//            }
//            else {
//                logger.fatal("FUCK");
//            }
//            Thread.sleep(1500);
//        }

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNWNiNzg3OTEwNGJiZmVlZDZjMzU0OTI4NDdmZTllZjA5ZDVmNTk2NDc2YmNjYjQwMTg1NGJmYWIxYTljNDFiOTJjZTE4YWNiOTVjMWY1MzQiLCJpYXQiOjE3NDc4NjA5ODcuNzgzOTQ4LCJuYmYiOjE3NDc4NjA5ODcuNzgzOTUsImV4cCI6MjIyMTI0NjU4Ny43Nzk3NjYsInN1YiI6IjEiLCJzY29wZXMiOltdfQ.QHDHeRmIuPwQysZSrQTOWAYuW0r3lm6JHHYW1czKE-VqFrVFk9i_34bnqS6v_FzGfEaMGkMvUbvFL815v7drCJD-YcB6BlVkpCqmrPOuCfAzgrpLnKy1MfIKatMli1juqYfCQRcZlmWc9xn_zwxlcLD7bdHT4LM-pwz2iLqK7HhJrdpq8wqmT-ru0Hgne8KZ3Jwwv_AWZ-13fPYpI5nXd2qePO7hCpZly6ywU19UNk-5Gnx9gai_-BvN8TMBFG60eXTDrnydNlTafj7xvmfwZHB3HXG8g8yCy_3T4CbRhE_BZQIA2gD33bGBJ6zqUlhq3lT61gW7uXsJYcexe9EfPEYgsMh3fxjXqaTGqiE8zMSWA_U7Ev1Ety7dOhYg-OH9W0nonDPkEMUHKCPquG87_MbB2O6AhPhmgw9-yM2-YfNazPHJqBSXhDoOvKeZD9qx9_bfG2lTGLpbPsniAq9Zew0rXl-cyuSSxbSgeLzIZrrvTgS7dQQDuijECcJw4AgAd3ucrpaNp_RFIElwcg1rZqG7EN3Eh2AaeyHRnLr3XwprK5-x6u-pl3Y8HHQVXnUC0fgLtDYmp9xPaV8SP5fKIEKpWACA4hVZ20PaqxCM2Toq68vPOVAoxujD90uFqXz-ohtF_QckCY1lrj4T7JePqjjBM4xk3fobg5_IkbzUgh4";
        String apiEndpoint = "http://10.0.0.61/api/v1";
        SnipeClient client = new SnipeClient(token, apiEndpoint);
        AssetModule assetModule = client.getAssets();

//        Asset asset = assetModule.fetchAssetByTag("CORPIT08").join();
//        logger.info(asset.getAge().orElse("FUCK"));
//
//        byte[] labels = assetModule.generateLabels(List.of("CORPIT08")).join();
//        logger.info(new String(labels));

        List<Asset> assets = assetModule.fetchAssets(100,0).join();
        logger.fatal(assets.get(0));
        System.exit(0);

        //logger.info(asset.getCustomFields().orElse(null).getFields().toString());
    }
}
