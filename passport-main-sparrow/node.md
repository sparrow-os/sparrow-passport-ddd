
- 原生的ognl 仅支持
```aidl
${flash_exception_result?flash_exception_result.message:''}
```
- spring ognl 支持
```aidl
${flash_exception_result?.message:''}

${flash_exception_result?flash_exception_result.message:''}

```