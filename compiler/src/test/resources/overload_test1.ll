declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str_2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define i32 @overload(i32 %tmp0,i32 %tmp2) {
%tmp1 = alloca i32, align 4
store i32 %tmp0, i32* %tmp1, align 4
%tmp3 = alloca i32, align 4
store i32 %tmp2, i32* %tmp3, align 4
store i32 3, i32* %tmp1, align 4
store i32 5, i32* %tmp3, align 4
%1 = load i32, i32* %tmp1, align 4
%2 = load i32, i32* %tmp3, align 4
%3 = add i32 %1, %2
ret i32 %3
}
define i32 @main() {
%1 = alloca i32, align 4
store i32 4, i32* %1, align 4
%2 = alloca i32, align 4
store i32 6, i32* %2, align 4
%3 = load i32, i32* %1, align 4
%4 = load i32, i32* %2, align 4
%5 = call i32 @overload(i32 %3,i32 %4)
%6 = load i32, i32* %1, align 4
%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),i32 %6)
%8 = load i32, i32* %2, align 4
%9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_2, i64 0, i64 0),i32 %8)
ret i32 0
}
