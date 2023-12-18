package adraft;

import com.sun.deploy.util.ReflectionUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author atong
 * @program draft
 * @description
 * @create 2023-12-12 16:27
 */
public class NioEventLoopDemo {
/*    public Selector selector;
    public SelectedSelectionKeySet selectedKeys;
    public SelectorProvider provider = new KQueueSelectorProvider();
    public Selector unwrappedSelector;
    public NioEventLoopDemo() throws IOException {

        unwrappedSelector = provider.openSelector();
        Object maybeSelectorImplClass = AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
            try {
                return Class.forName(
                        "sun.nio.ch.SelectorImpl",
                        false,
                        PlatformDependent.getSystemClassLoader());
            } catch (Throwable cause) {
                return cause;
            }
        });

        final Class<?> selectorImplClass = (Class<?>) maybeSelectorImplClass;
        final SelectedSelectionKeySet selectedKeySet = new SelectedSelectionKeySet();

        Object maybeException = AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
            try {
                Field selectedKeysField = selectorImplClass.getDeclaredField("selectedKeys");
                Field publicSelectedKeysField = selectorImplClass.getDeclaredField("publicSelectedKeys");
                Throwable cause = ReflectionUtil.trySetAccessible(selectedKeysField, true);
                if (cause != null) {
                    return cause;
                }
                cause = ReflectionUtil.trySetAccessible(publicSelectedKeysField, true);
                if (cause != null) {
                    return cause;
                }
                selectedKeysField.set(unwrappedSelector, selectedKeySet);
                publicSelectedKeysField.set(unwrappedSelector, selectedKeySet);
                return null;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                return e;
            }
        });
        selectedKeys = selectedKeySet;
    }

    public static void main(String[] args) throws IOException {
        NioEventLoopDemo nioEventLoopDemo = new NioEventLoopDemo();
        // 创建 Selector
        Selector selector = Selector.open();

        // 创建 ServerSocketChannel，并注册到 Selector
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false); // 设置为非阻塞模式
        SelectionKey selectionKey = sc.register(selector, SelectionKey.OP_CONNECT);
        nioEventLoopDemo.unwrappedSelector.selectedKeys().add(selectionKey);
        System.out.println(nioEventLoopDemo.selectedKeys);
        System.out.println(nioEventLoopDemo.selectedKeys);
        System.out.println(nioEventLoopDemo.selectedKeys);
        System.out.println(nioEventLoopDemo.selectedKeys);
    }*/
}
