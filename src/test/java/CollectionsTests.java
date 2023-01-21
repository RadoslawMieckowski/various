
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CollectionsTests {
    @Test
    void reverseCollectionTest() {
        List<Integer> integerCollection = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        Collections.reverse(integerCollection);

        assertEquals(5, integerCollection.get(0));
    }

    @Test
    void ColllectionsCopyOfGivesUndependableList() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> copyList = new ArrayList<>(List.of(0, 0, 0, 0, 0));
//        Collections.fill(copyList, 0);// podmienia elementy, ale nie dodaje nowych!

        Collections.copy(copyList, list);
        copyList.add(1);

        assertEquals(5, list.size());
        assertEquals(6, copyList.size());
        assertNotEquals(list, copyList);
    }

    @Test
    void CollectionsSwapIndexOutOfBoundsShouldThrowIndexOutOfBoundsException() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        assertThrows(IndexOutOfBoundsException.class,
                () -> Collections.swap(list, 0, 5));
    }


}
