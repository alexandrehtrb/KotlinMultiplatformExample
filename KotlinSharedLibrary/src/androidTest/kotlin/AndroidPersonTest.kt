import br.alexandrehtrb.kotlinsharedlibrary.Person
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidPersonTest {

    @Test
    fun testPerson_createApplicationScreenMessage() {
        val person = Person("John", 20)
        assertEquals("John", person.name)
        assertEquals(20, person.age)
        val message = "John, 20 years old, is using Kotlin Multiplatform in Android"
        assertTrue(person.createApplicationScreenMessage().contains(message))
    }
}