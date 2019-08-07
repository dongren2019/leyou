import com.leyou.common.pojo.UserInfo;
import com.leyou.common.utils.JwtUtils;
import com.leyou.common.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author dongren
 * @create 2019-08-07 15:50
 */
public class JwtTest {

    private static final String pubKeyPath = "D:\\july-leyou\\rsa\\rsa.pub";

    private static final String priKeyPath = "D:\\july-leyou\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU2NTE2NDczN30.YtNwNz5_O_i912W9zEhPyj-pamUSS5i9B_3geZJ2XAeCCGVarTDNQSSibj1Zdkyr16dXFnWbGphNNf1bgDrScro_mYLtqniWcrnzSvOlSyJJVfrsMaDe76x_cmp_E6EXfE4gT255N_cKPkkWGUr3Sm4l5-MARFt-YGVhLQD8m-M";
        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
