public interface DeveloperRepository extends GenericRepository <Developer, Long> {

    default long createDeveloperID () {
        return (long) (Math.random () * (Math.pow (2, 64) - 1));
    }
}
