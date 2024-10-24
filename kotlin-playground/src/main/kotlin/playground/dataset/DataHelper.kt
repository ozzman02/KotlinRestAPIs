package playground.dataset

const val KAFKA = "Kafka"
const val ADVERTISING = "Advertising"
const val BUSINESS_ANALYTICS = "Business Analytics"
const val USER_EXPERIENCE_DESIGN = "User Experience Design"
const val SPRING_BOOT = "SpringBoot"
const val JAVA = "java"
const val REACTIVE_PROGRAMMING = "Reactive Programming"
const val MULTI_THREADING = "MultiThreading"
const val INTEGRATION_TESTING = "Integration Testing"

data class Course(
    val id: Int,
    val name: String,
    val category: CourseCategory,
    val topicsCovered: List<String>
)

enum class CourseCategory{
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

data class Instructor(
    val name: String,
    val age: Int,
    val noOfCourses : Int,
    val coursesTaught : List<Course>
)


fun courseList(): MutableList<Course> {

    return mutableListOf(
        Course(
            1,
            "Apache Kafka for Developers using SpringBoot",
            CourseCategory.DEVELOPMENT,
            mutableListOf(KAFKA, JAVA, SPRING_BOOT)
        ),
        Course(
            2,
            "Apache Kafka for Beginners",
            CourseCategory.DEVELOPMENT,
            mutableListOf(KAFKA, JAVA)
        ),
        Course(
            3,
            "Multithreading, Parallel and Asynchronous Coding Modern Java ",
            CourseCategory.DEVELOPMENT,
            mutableListOf(JAVA, MULTI_THREADING)
        ),
        Course(
            4,
            "Modern Java - Learn Java 8 Features By coding it",
            CourseCategory.DEVELOPMENT,
            mutableListOf(JAVA)
        ),
        Course(
            5,
            "Reactive Programming in Modern Java using Project Reactor",
            CourseCategory.DEVELOPMENT,
            mutableListOf(REACTIVE_PROGRAMMING, JAVA)
        ),
        Course(
            6,
            "Build Reactive MicroServices using Spring WebFlux/SpringBoot",
            CourseCategory.DEVELOPMENT,
            mutableListOf(REACTIVE_PROGRAMMING, JAVA, SPRING_BOOT)
        ),
        Course(
            7,
            "Wiremock for Java Developers",
            CourseCategory.DEVELOPMENT,
            mutableListOf(JAVA, INTEGRATION_TESTING)
        ),
        Course(
            8,
            "FaceBook Marketing",
            CourseCategory.MARKETING,
            mutableListOf(ADVERTISING)
        ),
        Course(
            9,
            "Product Management",
            CourseCategory.BUSINESS,
            mutableListOf(BUSINESS_ANALYTICS)
        ),
        Course(
            11,
            "UI/UX Design",
            CourseCategory.DESIGN,
            mutableListOf(USER_EXPERIENCE_DESIGN)
        )
    )
}