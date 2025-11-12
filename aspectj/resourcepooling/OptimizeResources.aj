aspect OptimizeResources {

    private ResourceManager manager = new ResourceManager();

    pointcut destroy(Resource r) :
        target(r) && call(void Resource.destroy());

    pointcut instantiate() :
        call(Resource+.new(..));

    before(Resource r): destroy(r) {
        manager.releaseResource(r.getClass().getName(), r);
    }

    Object around(): instantiate() {
        return manager.getResource(thisJoinPoint.getSignature().getDeclaringTypeName());
    }

}
