declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"HI\0A\00"
@.str_2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str_3 = private unnamed_addr constant [22 x i8] c"%d\0A^This should be 5\0A\00"
@.str_4 = private unnamed_addr constant [28 x i8] c"%d\0A^This should be 4 again\0A\00"

define i32 @say_hello_and_add([10 x i32] %tmp0,i32 %tmp2) {
%tmp1 = alloca [10 x i32], align 4
store [10 x i32] %tmp0, [10 x i32]* %tmp1, align 4
%tmp3 = alloca i32, align 4
store i32 %tmp2, i32* %tmp3, align 4
%1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0))
%array1 = getelementptr [10 x i32], [10 x i32]* %tmp1, i64 0, i64 0
%2 = load i32, i32* %array1
%3 = load i32, i32* %tmp3, align 4
%4 = add i32 %2, %3
ret i32 %4
}
define i32 @main() {
%array1 = alloca [10 x i32]
%array2 = getelementptr [10 x i32], [10 x i32]* %array1, i64 0, i64 0
store i32 3, i32* %array2, align 4
%1 = alloca i32, align 4
store i32 4, i32* %1, align 4
%2 = alloca i32, align 4
store i32 3, i32* %2, align 4
%3 = load [10 x i32], [10 x i32]* %array1, align 4
%4 = load i32, i32* %2, align 4
%5 = call i32 @say_hello_and_add([10 x i32] %3,i32 %4)
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_2, i64 0, i64 0),i32 %5)
%array3 = getelementptr [10 x i32], [10 x i32]* %array1, i64 0, i64 0
%7 = load i32, i32* %array3
%8 = trunc i32 %7 to i1
br i1 %8, label %if1true, label %if1false

if1true:
%9 = alloca i32, align 4
store i32 5, i32* %9, align 4
%10 = load i32, i32* %9, align 4
%11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([22 x i8], [22 x i8]* @.str_3, i64 0, i64 0),i32 %10)
br label %if1end

if1false:
store i32 6, i32* %1, align 4
br label %if1end

if1end:
%12 = load i32, i32* %1, align 4
%13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([28 x i8], [28 x i8]* @.str_4, i64 0, i64 0),i32 %12)
%14 = load i32, i32* %1, align 4
%array4 = getelementptr [10 x i32], [10 x i32]* %array1, i64 0, i64 0
%15 = load i32, i32* %array4
%16 = add i32 %14, %15
ret i32 %16
}
