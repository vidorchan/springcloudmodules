package com.vidor;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    static class MyClassLoader extends ClassLoader {

        private String classPath;

        public MyClassLoader(String classPath){
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws IOException {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        /*
        自定义类加载器主要是重写findClass方法
         */
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        /*
        覆写ClassLoader中的loadClass方法，打破双亲委派机制
         */
        protected Class<?> loadClass1(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    try {
                        if (!name.startsWith("com.vidor")) {
                            c = this.getParent().loadClass(name);
                        } else {
                            c = findClass(name);
                        }
                    } catch (ClassNotFoundException e) {
                        // ClassNotFoundException thrown if class not found
                        // from the non-null parent class loader
                    }
                      // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t0);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    /*
    自定义类加载器加载。。。
    com.vidor.MyClassLoaderTest$MyClassLoader
    因为你打破了双亲委派机制loadClass
    如果不覆写loadClass,结果为:    sun.misc.Launcher$AppClassLoader
    自定义类加载器的parent都是this.loader 系统默认加载器 应用程序类加载器
     */
    public static void main(String[] args) throws Exception {
//        MyClassLoader classLoader  = new MyClassLoader("D:\\IdeaProjects\\JVM\\out\\production\\JVM");
//        Class<?> loadClass = classLoader.loadClass("com.vidor.User");
//        Object instance = loadClass.newInstance();
//        Method method = loadClass.getDeclaredMethod("sout", null);
//        Object o = method.invoke(instance);
//        System.out.println(loadClass.getClassLoader().getClass().getName());
    }
}
