package utils

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestCompareVersion(t *testing.T) {
	result, err := VersionCompare("0.99", "1.11", LessThan)
	assert.NoError(t, err)
	assert.Equal(t, true, result)
	result, err = VersionCompare("0.99", "0.88", LessThan)
	assert.NoError(t, err)
	assert.Equal(t, false, result)
}
