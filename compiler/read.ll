@.str_1 = private unnamed_addr constant [4 x i8] c"HI\0A\00"
declare i32 @printf(i8*, ...)

define void @say_hello() {
%1 = call i32 @println(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0))
ret void
}
define i32 @main() {
%1 = alloca i32, align 4
store i32 2, i32* %1, align 4
call void @say_hello()
%2 = load i32, i32* %1, align 4
ret i32 %2
}

