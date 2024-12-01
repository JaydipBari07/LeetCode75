import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidCollision {

    /**
     * Accepted
     * TC: 86.92%
     * SC: 96.73%
     */
    public int[] approach3(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, len = asteroids.length;
        while (i < len) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == -asteroids[i]) {
                    stack.pop();
                }
            }
            i++;
        }
        final int[] res = new int[stack.size()];
        i = stack.size() - 1;
        for (; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    /**
     * Some cases not passed
     */
    public int[] approach2(int[] asteroids) {
        List<Integer> stack1 = Arrays.stream(asteroids).boxed().collect(Collectors.toList());
        List<Integer> stack2 = new ArrayList<>();
        int len = asteroids.length;
        while (!stack1.isEmpty()) {
            int currentAsteroid = top(stack1);
            if (!stack2.isEmpty()) {
                int lastAsteroid = top(stack2);
                if ((currentAsteroid > 0 && lastAsteroid > 0) || (currentAsteroid < 0 && lastAsteroid < 0)) {
                    push(stack2, pop(stack1));
                } else {
                    currentAsteroid = top(stack1);
                    lastAsteroid = top(stack2);
                    while (!stack1.isEmpty()) {
                        if (Math.abs(currentAsteroid) > Math.abs(lastAsteroid)) {
                            pop(stack2);
                            push(stack2, pop(stack1));
                            break;
                        } else if (Math.abs(currentAsteroid) < Math.abs(lastAsteroid)) {
                            if (!stack1.isEmpty()) {
                                pop(stack1);
                                currentAsteroid = top(stack1);
                            } else {
                                break;
                            }
                        } else {
                            pop(stack1);
                            pop(stack2);
                        }
                    }
                }
            } else {
                push(stack2, pop(stack1));
            }
        }
        int l = stack2.size();
        int[] res = new int[l];
        for (int i = 0; i < l; i++) {
            res[i] = pop(stack2);
        }
        return res;
    }

    public void push(List<Integer> stack, int val) {
        stack.add(val);
    }

    public int pop(List<Integer> stack) {
        return stack.remove(stack.size() - 1);
    }

    public int top(List<Integer> stack) {
        return stack.get(stack.size() - 1);
    }

    public void merge(List<Integer> stack1, List<Integer> stack2) {
        while (!stack2.isEmpty()) {
            push(stack1, pop(stack2));
        }
    }

    public int[] approach1(int[] asteroids) {
        List<Integer> ast = new ArrayList<>();
        int len = asteroids.length;
        boolean isLastAsteroidRight = asteroids[len - 1] > 0;
        int collider = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if ((isLastAsteroidRight && asteroids[i] > 0) || (!isLastAsteroidRight && asteroids[i] < 0)) {
                ast.add(asteroids[i]);
                collider = i;
            } else {
                while (i >= 0) {
                    if (Math.abs(asteroids[collider]) > Math.abs(asteroids[i])) {
                        i--;
                    } else if (Math.abs(asteroids[collider]) == Math.abs(asteroids[i])) {
                        i--;
                        if (collider + 1 < len) {
                            collider++;
                        } else {
                            collider = i;
                            i--;
                        }
                    } else {
                        ast.add(asteroids[i]);
                        if (collider + 1 < len) {
                            collider++;
                        } else {
                            collider = i;
                        }
                        i--;
                    }
                }
            }
        }
        int[] res = new int[ast.size()];
        for (int i = res.length - 1, j = 0; i >= 0 & j < res.length; i--, j++) {
            res[j] = ast.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = new int[]{-2, -1, 1, 2};   //Expected = [-2,-1,1,2]
//        int[] asteroids = new int[]{5, 10, -5};
//        int[] asteroids = new int[]{8, -8};
        System.out.println(Arrays.toString(new AsteroidCollision().approach3(asteroids)));
    }

}
