import org.specs2.ScalaCheck
import org.specs2.mutable.Specification
import org.specs2.specification.core.Fragment

class SortSpec extends Specification with ScalaCheck {
  private def sortChecks(sort: Vector[Int] => Vector[Int]): Fragment = {
    "return sorted array" in {
      prop { input: Vector[Int] =>
        sort(input) must be sorted
      }
    }

    "preserve all elements" in {
      prop { input: Vector[Int] =>
        sort(input) must containTheSameElementsAs(input)
      }
    }

    "keep array length" in {
      prop { input: Vector[Int] =>
        sort(input) must have size input.length
      }
    }
  }

  "sort" should {
    sortChecks(SortImpl.sort)
  }

  "broken sort" should {
    // сохраняет условие сортированности, но нарушает
    // условие числа элементов и состава элементов
    sortChecks(SortImpl.brokenSort)
  }

  "broken sort 2" should {
    // нарушает условие сортированности для краевого случая с переполнением int
    // нарушает условие состава элементов
    // сохраняет условие длины вектора
    sortChecks(SortImpl.brokenSort2)
  }
}
