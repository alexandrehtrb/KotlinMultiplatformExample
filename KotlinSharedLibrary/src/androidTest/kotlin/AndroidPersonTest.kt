import br.alexandrehtrb.kotlinsharedlibrary.Parcelable
import br.alexandrehtrb.kotlinsharedlibrary.Person

import java.io.Serializable

import org.junit.Assert
import org.junit.Test

class AndroidPersonTest {

    @Test
    fun testAndroidPerson() {
        val person = Person("John", 20)
        Assert.assertEquals(3, 1 + 2)
        Assert.assertEquals("John", person.name)
        Assert.assertEquals(20, person.age)
        Assert.assertTrue(person.platformName.contains("Android", ignoreCase = false))
        Assert.assertTrue(person is Serializable)
        Assert.assertTrue(person is Parcelable)
    }

}