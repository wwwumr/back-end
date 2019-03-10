package src;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class WordLadderTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(WordLadder.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @DisplayName("test getWordList()")
    void testWordList(){
        WordLadder wordLadder = new WordLadder();
        HashMap<String> set = wordLadder.getWordList();
        assertEquals(set.contains("cat"),true);
        assertEquals(set.contains("dog"),true);
        assertEquals(set.contains("map"),true);
        assertEquals(set.contains("set"),true);
    }

}
