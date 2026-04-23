# AI Usage Report

## Tool Used
ChatGPT

## Chat Exchange

**Me:** I need to build a report system in Java using the Template Method pattern. Where do I start?

**AI:** Start with an abstract class that defines the overall workflow in one method — that's your template method. It calls a series of steps in a fixed order. The steps themselves are abstract, so each subclass fills them in differently.

**Me:** Should the template method be abstract too?

**AI:** No, the template method should be concrete and marked final. You want subclasses to override the individual steps, not the overall workflow. If they could override generateReport() itself, the pattern breaks down.

**Me:** How do I show polymorphism in the driver?

**AI:** Declare your list as List<Report> and add both StudentReport and CourseReport to it. Then loop through and call generateReport() on each. Java will dispatch to the correct subclass at runtime even though your reference type is the abstract base.
