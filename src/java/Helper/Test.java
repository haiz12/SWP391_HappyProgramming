/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.codec.digest.HmacUtils;
import org.json.JSONObject;

/**
 *
 * @author admin
 */
public class Test {
    static String checksumKey = "7d658bb8f79a376ae465fff171e4810951617dec4945c4c604ea6be4da5fa09e";
    
    static String json = "{\"amount\":\"200000\",\"cancelUrl\":\"http://localhost:9999/Happy_v1/cancel-payment\",\"description\":\"48319657\",\"orderCode\":557,\"returnUrl\":\"http://localhost:9999/Happy_v1/success-payment\"}";

    static String transaction = "{'orderCode':123,'amount':3000,'description':'VQRIO123','accountNumber':'12345678','reference':'TF230204212323','transactionDateTime':'2023-02-04 18:25:00','currency':'VND','paymentLinkId':'124c33293c43417ab7879e14c8d9eb18','code':'00','desc':'Thành công','counterAccountBankId':'','counterAccountBankName':'','counterAccountName':'','counterAccountNumber':'','virtualAccountName':'','virtualAccountNumber':''}";

    static String transactionSignature = "47bcb251d6f4c5b6b81a521a3d070c8e50097c71834764cb35feadd011dc141e";

    public static Boolean isValidData(String transaction, String transactionSignature) {
        try {
            JSONObject jsonObject = new JSONObject(transaction);
            Iterator<String> sortedIt = sortedIterator(jsonObject.keys(), (a, b) -> a.compareTo(b));

            StringBuilder transactionStr = new StringBuilder();
            while (sortedIt.hasNext()) {
                String key = sortedIt.next();
                String value = jsonObject.get(key).toString();
                transactionStr.append(key);
                transactionStr.append('=');
                transactionStr.append(value);
                if (sortedIt.hasNext()) {
                    transactionStr.append('&');
                }
            }

            String signature = new HmacUtils("HmacSHA256", checksumKey).hmacHex(transactionStr.toString());
            return signature.equals(transactionSignature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Iterator<String> sortedIterator(Iterator<?> it, Comparator<String> comparator) {
        List<String> list = new ArrayList<String>();
        while (it.hasNext()) {
            list.add((String) it.next());
        }

        Collections.sort(list, comparator);
        return list.iterator();
    }

    public static void main(String[] args) {
        System.out.println(Timestamp.from(Instant.now().plus(1, ChronoUnit.DAYS)));;
    }
}
