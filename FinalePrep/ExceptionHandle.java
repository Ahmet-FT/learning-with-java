
public class ExceptionHandle {
    /*istisnai bir durrum ortaya çıktığında,
     o istisnayı temsil eden bir nesen yaratılır ve hataya sebep olan metodun içine atılır(throw)
     
     programcının olaya nasıl bakması herektiğiyle ilgili olarak bu metot istisnayı yakalar
     (catch) ve işler ya da yakalnıp işlenmesi için istisnaya dokunmaz geçer.*/


    public void setRadius() throws Exception{
        try {
            throw new Exception("this is an exception");
        } catch(Exception e) {
            System.out.println("setRadius() exeption handled: " + e);
            throw e;
        }
     }

      public void setRadius2() throws Exception {
        try {
            setRadius();
        } catch (Exception e) {
            System.out.println("setRadius() exeption handled: " + e);
            throw e;
        }
     }

     public void start() {
        try {

            setRadius2();

        } catch (Exception e) {

            e.printStackTrace();

        }
     }
     public static void main(String[] args) {
        ExceptionHandle f = new ExceptionHandle();
        
        f.start();
        // so we are done
    }
}